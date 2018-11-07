package com.shortn0tes.feignexample.model.hitbtc;

import lombok.Data;

@Data
public class BidH {

    private String price;
    private String size;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
