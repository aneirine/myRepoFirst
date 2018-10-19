package com.shortn0tes.feignexample.model;

import lombok.Data;

@Data
public class ETH_BTC {

    private String ask_quantity;
    private String bid_quantity;
    private String[][] ask;
    private String bid_top;
    private String[][] bid;
    private String bid_amount;
    private String ask_top;
    private String ask_amount;

    public ETH_BTC() {
    }


}
