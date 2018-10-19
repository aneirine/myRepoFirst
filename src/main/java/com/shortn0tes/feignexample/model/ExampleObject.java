package com.shortn0tes.feignexample.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ExampleObject {
    private ETH_BTC eth_btc;

    public ExampleObject() {
    }

    public ETH_BTC getEth_btc() {
        return eth_btc;
    }

    @JsonSetter("ETH_BTC")
    public void setEth_btc(ETH_BTC eth_btc) {
        this.eth_btc = eth_btc;
    }
}
