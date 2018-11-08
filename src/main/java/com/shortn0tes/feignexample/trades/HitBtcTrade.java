package com.shortn0tes.feignexample.trades;

import lombok.Data;

import java.util.Objects;

@Data
public class HitBtcTrade {

    private String timestamp;
    private String id;
    private String price;
    private String side;
    private String quantity;

    public HitBtcTrade(String timestamp, String id, String price, String side, String quantity) {
        this.timestamp = timestamp;
        this.id = id;
        this.price = price;
        this.side = side;
        this.quantity = quantity;
    }

    public HitBtcTrade() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitBtcTrade that = (HitBtcTrade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
