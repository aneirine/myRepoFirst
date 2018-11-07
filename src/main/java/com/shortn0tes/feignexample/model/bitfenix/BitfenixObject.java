package com.shortn0tes.feignexample.model.bitfenix;

import lombok.Data;

@Data
public class BitfenixObject {

    private AsksBF[] asks;
    private BidsBF[] bids;

    public BitfenixObject() {
    }

}
