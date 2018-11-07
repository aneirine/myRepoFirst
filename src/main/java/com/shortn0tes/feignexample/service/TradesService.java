package com.shortn0tes.feignexample.service;

import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import com.shortn0tes.feignexample.feign.ExmoTradeClient;
import com.shortn0tes.feignexample.feign.HitBtcTradeClient;
import com.shortn0tes.feignexample.feign.HitbtcObjectClient;
import com.shortn0tes.feignexample.model.Trade;
import com.shortn0tes.feignexample.model.exmo.Book;
import com.shortn0tes.feignexample.model.hitbtc.AskH;
import com.shortn0tes.feignexample.model.hitbtc.BidH;
import com.shortn0tes.feignexample.model.hitbtc.HitbtcObject;
import com.shortn0tes.feignexample.repos.TradeRepo;
import com.shortn0tes.feignexample.trades.ExmoTrade;
import com.shortn0tes.feignexample.trades.HitBtcTrade;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


@Service
public class TradesService {

    private Set<?> previousTrades;
    private Set<?> trades;
    private String pair1, pair2;
    private double quantity, tradePrice;
    private String[][] offeredPrice;
    private String side;


    @Autowired
    ExmoObjectClient exampleObjectClient;

    @Autowired
    HitbtcObjectClient hitbtcObjectClient;

    @Autowired
    HitBtcTradeClient hitBtcTradeClient;

    @Autowired
    ExmoTradeClient exmoTradeClient;

    @Autowired
    TradeRepo tradeRepo;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Scheduled(fixedRate = 5000)
    void trade() throws IOException, ParseException {
        Object object = new JSONParser().parse(new FileReader("E:/java/myPr/feign-example-master/src/main/resources/files/file.json"));
        JSONObject jsonObject = (JSONObject) object;
        pair1 = (String) jsonObject.get("pairFirst");
        pair2 = (String) jsonObject.get("pairSecond");
        String tradeExchange = (String) jsonObject.get("tradeExchange");
        String orderExchange = (String) jsonObject.get("orderExchange");

        add(tradeExchange, orderExchange);


    }


    private void add(String tradeExchange, String orderExchange) {

     /*   if (tradeExchange.equals("HitBtc")) {
            trades = hitBtcTradeClient.getHitbtcObjects(pair1);
        } else if (tradeExchange.equals("Exmo")) {
            Map<String, List<ExmoTrade>> map = exmoTradeClient.getListExmoTrade(pair2);
            List<ExmoTrade> list = map.get(pair2);
            trades = new HashSet<>(list);
        }
*/


        if (previousTrades == null) {
            if (tradeExchange.equals("HitBtc")) {
                previousTrades = hitBtcTradeClient.getHitbtcObjects(pair1);
            } else if (tradeExchange.equals("Exmo")) {
                Map<String, List<ExmoTrade>> map = exmoTradeClient.getListExmoTrade(pair2);
                List<ExmoTrade> list = map.get(pair2);
                previousTrades = new HashSet<>(list);
            }
        } else {
            if (tradeExchange.equals("HitBtc")) {
                trades = hitBtcTradeClient.getHitbtcObjects(pair1);
                Set copy = new HashSet<>(trades);
                trades.removeAll(previousTrades);
                previousTrades = copy;
            } else if (tradeExchange.equals("Exmo")) {
                Map<String, List<ExmoTrade>> map = exmoTradeClient.getListExmoTrade(pair2);
                List<ExmoTrade> list = map.get(pair2);
                trades = new HashSet<>(list);
                Set copy = new HashSet<>(trades);
                trades.removeAll(previousTrades);
                previousTrades = copy;
            }
        }

        if (trades != null && !trades.isEmpty()) {


            if (orderExchange.equals("Exmo")) {
                Map<String, Book> exmoObject = exampleObjectClient.getExmoObject(pair2);

                for (Object trade : trades) {

                    HitBtcTrade hitBtcTrade = (HitBtcTrade) trade;
                    quantity = Double.valueOf(hitBtcTrade.getQuantity());
                    tradePrice = Double.valueOf(hitBtcTrade.getPrice()) * quantity;

                    side = hitBtcTrade.getSide();
                    System.out.println("side: " + side);

                    if (side.equals("sell")) {
                        offeredPrice = exmoObject.get(pair2).getAsk();
                    } else {
                        offeredPrice = exmoObject.get(pair2).getBid();
                    }


                }
            } else if (orderExchange.equals("HitBtc")) {
                HitbtcObject hitbtcObject = hitbtcObjectClient.getHitbtcObject(pair1);
                for (Object trade : trades) {

                    ExmoTrade exmoTrade = (ExmoTrade) trade;
                    quantity = Double.valueOf(exmoTrade.getQuantity());
                    tradePrice = Double.valueOf(exmoTrade.getPrice()) * quantity;

                    side = exmoTrade.getType();
                    if (side.equals("sell")) {
                        AskH[] askHS = hitbtcObject.getAsk();
                        offeredPrice = new String[askHS.length][2];
                        for (int i = 0; i < askHS.length; i++) {
                            offeredPrice[i][0] = askHS[i].getPrice();
                            offeredPrice[i][1] = askHS[i].getSize();
                        }
                    } else {
                        BidH[] bidHS = hitbtcObject.getBid();
                        offeredPrice = new String[bidHS.length][2];
                        for (int i = 0; i < bidHS.length; i++) {
                            offeredPrice[i][0] = bidHS[i].getPrice();
                            offeredPrice[i][1] = bidHS[i].getSize();
                        }
                    }

                }
            }
                double priceSecond = getPriceSecond(quantity, offeredPrice);
                double profit = profit(tradePrice, priceSecond);

                Date date = new Date();
                Trade tradeObject = new Trade(tradeExchange, orderExchange, tradePrice,
                        priceSecond, date, profit, side, pair2);
                logger.info("trades = " + tradeObject.toString());
                tradeRepo.save(tradeObject);
        }
    }


    private double getPriceSecond(double quantity, String[][] ask) {
        double countedPrice = 0, countedQuantity = 0, priceSecond = 0;

        for (int i = 0; i < ask.length; i++) {
            double quantityExmo = Double.valueOf(ask[i][1]);
            double price = Double.valueOf(ask[i][0]);

            if (quantityExmo >= quantity) {
                if (countedQuantity == 0) {
                    priceSecond = price * quantity;
                    break;
                } else {
                    double result = quantity - countedQuantity;
                    priceSecond = result * price + countedPrice;
                    break;
                }
            } else {
                countedPrice += quantityExmo * price;
                countedQuantity += quantityExmo;

            }
        }
        return priceSecond;
    }

    private double profit(double first, double second) {
        return first - second;
    }
}





