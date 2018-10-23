package com.shortn0tes.feignexample.controllers;

import com.shortn0tes.feignexample.feign.BitfenixObjectClient;
import com.shortn0tes.feignexample.feign.ExmoObjectClient;
import com.shortn0tes.feignexample.feign.HitbtcObjectClient;
import com.shortn0tes.feignexample.model.Price;
import com.shortn0tes.feignexample.model.bitfenix.AsksBF;
import com.shortn0tes.feignexample.model.bitfenix.BidsBF;
import com.shortn0tes.feignexample.model.bitfenix.BitfenixObject;
import com.shortn0tes.feignexample.model.exmo.ExmoObject;
import com.shortn0tes.feignexample.model.hitbtc.AskH;
import com.shortn0tes.feignexample.model.hitbtc.BidH;
import com.shortn0tes.feignexample.model.hitbtc.HitbtcObject;
import com.shortn0tes.feignexample.repos.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;


@Controller
public class ExampleController {

    @Autowired
    ExmoObjectClient exampleObjectClient;

    @Autowired
    BitfenixObjectClient bitfenixObjectClient;

    @Autowired
    HitbtcObjectClient hitbtcObjectClient;

    @Autowired
    PriceRepo priceRepo;


    @Scheduled(fixedRate = 10000)
    void add() {
        ExmoObject exmoObject = exampleObjectClient.getExmoObject("ETH_BTC");
        double valueAskExmo = Double.parseDouble(exmoObject.getBook().getAsk_top());
        double valueBidExmo = Double.parseDouble(exmoObject.getBook().getBid_top());

        BitfenixObject bitfenixObject = bitfenixObjectClient.getBitfenixObject();
        AsksBF[] bitfenixObjectAsks = bitfenixObject.getAsks();
        BidsBF[] bitfenixObjectBids = bitfenixObject.getBids();
        double valueAskBF = Double.parseDouble(bitfenixObjectAsks[0].getPrice());
        double valueBidBF = Double.parseDouble(bitfenixObjectBids[0].getPrice());

        HitbtcObject hitbtcObject = hitbtcObjectClient.getHitbtcObject();
        AskH[] askHS = hitbtcObject.getAsk();
        BidH[] bidHS = hitbtcObject.getBid();
        double valueAskHit = Double.parseDouble(askHS[0].getPrice());
        double valueBidHit = Double.parseDouble(bidHS[0].getPrice());


        Date date = new Date();

        Price exmo = new Price("Exmo", valueAskExmo, valueBidExmo, date);
        Price bitfenix = new Price("BitFenix", valueAskBF, valueBidBF, date);
        Price hitbtc = new Price("HitBTC", valueAskHit, valueBidHit, date);

        priceRepo.save(exmo);
        priceRepo.save(bitfenix);
        priceRepo.save(hitbtc);

        System.out.println("saved");

    }
}





