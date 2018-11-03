package com.shortn0tes.feignexample.service;

import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import com.shortn0tes.feignexample.feign.HitBtcTradeClient;
import com.shortn0tes.feignexample.model.Trade;
import com.shortn0tes.feignexample.model.exmo.Book;
import com.shortn0tes.feignexample.model.exmo.ExmoObject;
import com.shortn0tes.feignexample.repos.TradeRepo;
import com.shortn0tes.feignexample.trades.HitBtcTrade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Service
public class TradesService {

    private Set<HitBtcTrade> previousTrades;
    private Set<HitBtcTrade> trades;
    private String pair1 = "XRPBTC", pair2 = "XRP_BTC";


    @Autowired
    ExmoObjectClient exampleObjectClient;

    @Autowired
    HitBtcTradeClient hitBtcTradeClient;

    @Autowired
    TradeRepo tradeRepo;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRate = 5000)
    void add() {

        if (previousTrades == null) {
            previousTrades = hitBtcTradeClient.getHitbtcObjects(pair1);
        } else {
            trades = hitBtcTradeClient.getHitbtcObjects(pair1);
            Set<HitBtcTrade> copy = new HashSet<>(trades);
            trades.removeAll(previousTrades);
            previousTrades = copy;
        }


        if (trades != null && !trades.isEmpty()) {

            Map<String, Book> exmoObject = exampleObjectClient.getExmoObject(pair2);

            for (HitBtcTrade trade : trades) {

                //we need this quantity
                double quantity = Double.valueOf(trade.getQuantity());
                double tradePrice = Double.valueOf(trade.getPrice()) * quantity;

                String[][] offeredPrice;

                String side = trade.getSide();
                if(side.equals("sell")) {
                    offeredPrice = exmoObject.get(pair2).getAsk();
                } else {
                    offeredPrice = exmoObject.get(pair2).getBid();
                }

                double priceSecond = getPriceSecond(quantity, offeredPrice);
                double profit = profit(tradePrice, priceSecond);

                Date date = new Date();
                Trade tradeO = new Trade("HitBtc", "Exmo", tradePrice,
                        priceSecond, date, profit);
                logger.info("trades = " + tradeO.toString());
                tradeRepo.save(tradeO);

            }
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





