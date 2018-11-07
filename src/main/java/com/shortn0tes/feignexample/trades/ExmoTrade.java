package com.shortn0tes.feignexample.trades;

import lombok.Data;

@Data
public class ExmoTrade {

    private String trade_id;
    private String type;
    private String quantity;
    private String amount;
    private String date;
    private String price;

    public ExmoTrade() {

    }

}
