package com.shortn0tes.feignexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tradeExchange;
    private String orderExchange;
    private double firstPrice;
    private double secondPrice;
    private Date date;
    private double profit;
    private String side;
    private String pair;

    public Trade(String tradeExchange, String orderExchange, double firstPrice,
                 double secondPrice, Date date, double profit, String side, String pair) {
        this.tradeExchange = tradeExchange;
        this.orderExchange = orderExchange;
        this.firstPrice = firstPrice;
        this.secondPrice = secondPrice;
        this.date = date;
        this.profit = profit;
        this.side = side;
        this.pair = pair;
    }

    public Trade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstExchange() {
        return tradeExchange;
    }

    public void setFirstExchange(String tradeExchange) {
        this.tradeExchange = tradeExchange;
    }

    public String getSecondExchange() {
        return orderExchange;
    }

    public void setSecondExchange(String orderExchange) {
        this.orderExchange = orderExchange;
    }

    public double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }

    public double getSecondPrice() {
        return secondPrice;
    }

    public void setSecondPrice(double secondPrice) {
        this.secondPrice = secondPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTradeExchange() {
        return tradeExchange;
    }

    public void setTradeExchange(String tradeExchange) {
        this.tradeExchange = tradeExchange;
    }

    public String getOrderExchange() {
        return orderExchange;
    }

    public void setOrderExchange(String orderExchange) {
        this.orderExchange = orderExchange;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", tradeExchange='" + tradeExchange + '\'' +
                ", orderExchange='" + orderExchange + '\'' +
                ", firstPrice=" + firstPrice +
                ", secondPrice=" + secondPrice +
                ", date=" + date +
                ", profit=" + profit +
                ", side='" + side + '\'' +
                '}';
    }
}
