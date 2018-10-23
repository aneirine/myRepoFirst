package com.shortn0tes.feignexample.model.bitfenix;

import lombok.Data;

@Data
public class BitfenixObject {

    private AsksBF[] asks;
    private BidsBF[] bids;

    public BitfenixObject() {
    }


    public AsksBF[] getAsks() {
        return asks;
    }


    public void setAsks(AsksBF[] asks) {
        this.asks = asks;
    }

    public BidsBF[] getBids() {
        return bids;
    }

    public void setBids(BidsBF[] bids) {
        this.bids = bids;
    }
}
