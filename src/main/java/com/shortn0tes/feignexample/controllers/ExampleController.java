package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.BitfenixObjectClient;
import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import com.shortn0tes.feignexample.feign.HitBtcTradeClient;
import com.shortn0tes.feignexample.feign.HitbtcObjectClient;
import com.shortn0tes.feignexample.model.Price;
import com.shortn0tes.feignexample.model.Profit;
import com.shortn0tes.feignexample.model.bitfenix.AsksBF;
import com.shortn0tes.feignexample.model.bitfenix.BidsBF;
import com.shortn0tes.feignexample.model.bitfenix.BitfenixObject;
import com.shortn0tes.feignexample.model.exmo.ExmoObject;
import com.shortn0tes.feignexample.model.hitbtc.AskH;
import com.shortn0tes.feignexample.model.hitbtc.BidH;
import com.shortn0tes.feignexample.model.hitbtc.HitbtcObject;
import com.shortn0tes.feignexample.repos.PriceRepo;
import com.shortn0tes.feignexample.repos.ProfitRepo;
import com.shortn0tes.feignexample.trades.HitBtcTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Controller
public class ExampleController {
    Set<HitBtcTrade> hitBtcTradeSet;
    Set<HitBtcTrade> newHitBtcTradeSet;

    @Autowired
    ExmoObjectClient exampleObjectClient;

    @Autowired
    BitfenixObjectClient bitfenixObjectClient;

    @Autowired
    HitbtcObjectClient hitbtcObjectClient;

    @Autowired
    PriceRepo priceRepo;

    @Autowired
    ProfitRepo profitRepo;

    @Autowired
    HitBtcTradeClient hitBtcTradeClient;


    @Scheduled(fixedRate = 10000)
    void add() {

        if(hitBtcTradeSet == null){
            hitBtcTradeSet = hitBtcTradeClient.getHitbtcObjects();
        } else {
            newHitBtcTradeSet = hitBtcTradeClient.getHitbtcObjects();
            newHitBtcTradeSet.removeAll(hitBtcTradeSet);
        }

        if(newHitBtcTradeSet != null){

        }






    }
}





