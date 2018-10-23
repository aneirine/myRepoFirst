package com.shortn0tes.feignexample.model.bitfenix;

import lombok.Data;

@Data
public class AsksBF {

    private String timestamp;
    private String amount;
    private String price;

    public AsksBF() {
    }

}
