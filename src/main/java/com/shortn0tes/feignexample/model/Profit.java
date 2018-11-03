package com.shortn0tes.feignexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Profit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sellingExchange;
    private String buyingExchange;

    private double sellingPrice;
    private double buyingPrice;
    private double profit;

    private Date date;

    public Profit(String sellingExchange, String buyingExchange, double sellingPrice,
                  double buyingPrice, double profit, Date date) {
        this.sellingExchange = sellingExchange;
        this.buyingExchange = buyingExchange;
        this.sellingPrice = sellingPrice;
        this.buyingPrice = buyingPrice;
        this.profit = profit;
        this.date = date;
    }

    public Profit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellingExchange() {
        return sellingExchange;
    }

    public void setSellingExchange(String sellingExchange) {
        this.sellingExchange = sellingExchange;
    }

    public String getBuyingExchange() {
        return buyingExchange;
    }

    public void setBuyingExchange(String buyingExchange) {
        this.buyingExchange = buyingExchange;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
