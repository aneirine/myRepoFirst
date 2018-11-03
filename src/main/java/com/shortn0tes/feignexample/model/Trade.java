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

    private String firstExchange;
    private String secondExchange;
    private double firstPrice;
    private double secondPrice;
    private Date date;
    private double profit;

    public Trade(String firstExchange, String secondExchange, double firstPrice,
                 double secondPrice, Date date, double profit) {
        this.firstExchange = firstExchange;
        this.secondExchange = secondExchange;
        this.firstPrice = firstPrice;
        this.secondPrice = secondPrice;
        this.date = date;
        this.profit = profit;
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
        return firstExchange;
    }

    public void setFirstExchange(String firstExchange) {
        this.firstExchange = firstExchange;
    }

    public String getSecondExchange() {
        return secondExchange;
    }

    public void setSecondExchange(String secondExchange) {
        this.secondExchange = secondExchange;
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

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", firstExchange='" + firstExchange + '\'' +
                ", secondExchange='" + secondExchange + '\'' +
                ", firstPrice=" + firstPrice +
                ", secondPrice=" + secondPrice +
                ", date=" + date +
                ", profit=" + profit +
                '}';
    }
}
