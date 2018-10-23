package com.shortn0tes.feignexample.model.hitbtc;

public class HitbtcObject {

    private AskH[] ask;
    private BidH[] bid;

    public AskH[] getAsk() {
        return ask;
    }

    public void setAsk(AskH[] ask) {
        this.ask = ask;
    }

    public BidH[] getBid() {
        return bid;
    }

    public void setBid(BidH[] bid) {
        this.bid = bid;
    }
}

