package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import com.shortn0tes.feignexample.feign.HitBtcTradeClient;
import com.shortn0tes.feignexample.model.Trade;
import com.shortn0tes.feignexample.model.exmo.ExmoObject;
import com.shortn0tes.feignexample.repos.TradeRepo;
import com.shortn0tes.feignexample.trades.HitBtcTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Set;


@Controller
public class ExampleController {
    Set<HitBtcTrade> hitBtcTradeSet;
    Set<HitBtcTrade> newHitBtcTradeSet;

    @Autowired
    ExmoObjectClient exampleObjectClient;

    @Autowired
    HitBtcTradeClient hitBtcTradeClient;

    @Autowired
    TradeRepo tradeRepo;


    @Scheduled(fixedRate = 60000)
    void add() {

        if (hitBtcTradeSet == null) {
            hitBtcTradeSet = hitBtcTradeClient.getHitbtcObjects();
        } else {
            newHitBtcTradeSet = hitBtcTradeClient.getHitbtcObjects();
            newHitBtcTradeSet.removeAll(hitBtcTradeSet);
        }

        if (newHitBtcTradeSet != null) {

            ExmoObject exmoObject = exampleObjectClient.getExmoObject("KICK_BTC");

            for (HitBtcTrade temp : newHitBtcTradeSet) {

                //we need this quantity
                double quantity = Double.valueOf(temp.getQuantity());
                double priceFirst = Double.valueOf(temp.getPrice()) * quantity;

                String[][] ask = exmoObject.getBook().getAsk();

                double counted = 0, thisQuantity = 0, priceSecond = 0;

                for (int i = 0; i < ask.length; i++) {
                    double quantityExmo = Double.valueOf(ask[i][1]);
                    double price = Double.valueOf(ask[i][0]);

                    if (quantityExmo >= quantity) {
                        if (thisQuantity == 0) {
                            priceSecond = price * quantity;
                            break;
                        } else {
                            double result = quantity - thisQuantity;
                            priceSecond = result * price + counted;
                            break;
                        }
                    } else {
                        counted += quantityExmo * price;
                        thisQuantity += quantityExmo;

                    }
                }
                double profit = priceFirst - priceSecond;
                Date date = new Date();
                Trade trade = new Trade("HitBtc", "Exmo", priceFirst,
                        priceSecond, date, profit);
                tradeRepo.save(trade);
            }
        }
    }
}





