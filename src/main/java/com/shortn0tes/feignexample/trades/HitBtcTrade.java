package com.shortn0tes.feignexample.trades;

import java.util.Objects;

public class HitBtcTrade extends MyTrade{

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
