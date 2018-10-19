package com.shortn0tes.feignexample.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;


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

    public String getAsk_quantity() {
        return ask_quantity;
    }

    @JsonSetter("ask_quantity")
    public void setAsk_quantity(String ask_quantity) {
        this.ask_quantity = ask_quantity;
    }

    public String getBid_quantity() {
        return bid_quantity;
    }


    @JsonSetter("bid_quantity")
    public void setBid_quantity(String bid_quantity) {
        this.bid_quantity = bid_quantity;
    }

    public String[][] getAsk() {
        return ask;
    }

    @JsonSetter("ask")
    public void setAsk(String[][] ask) {
        this.ask = ask;
    }

    public String getBid_top() {
        return bid_top;
    }

    @JsonSetter("bid_top")
    public void setBid_top(String bid_top) {
        this.bid_top = bid_top;
    }

    public String[][] getBid() {
        return bid;
    }

    @JsonSetter("bid")
    public void setBid(String[][] bid) {
        this.bid = bid;
    }

    public String getBid_amount() {
        return bid_amount;
    }

    @JsonSetter("bid_amount")
    public void setBid_amount(String bid_amount) {
        this.bid_amount = bid_amount;
    }

    public String getAsk_top() {
        return ask_top;
    }

    @JsonSetter("ask_top")
    public void setAsk_top(String ask_top) {
        this.ask_top = ask_top;
    }

    public String getAsk_amount() {
        return ask_amount;
    }

    @JsonSetter("ask_amount")
    public void setAsk_amount(String ask_amount) {
        this.ask_amount = ask_amount;
    }
}
