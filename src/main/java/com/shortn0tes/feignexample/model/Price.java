package com.shortn0tes.feignexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String exchange;
    private double valueAsk;
    private double valueBid;
    private Date date;

    public Price() {
    }

    public Price(String exchange, double valueAsk, double valueBid, Date date) {
        this.exchange = exchange;
        this.valueAsk = valueAsk;
        this.valueBid = valueBid;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public double getValueAsk() {
        return valueAsk;
    }

    public void setValueAsk(double valueAsk) {
        this.valueAsk = valueAsk;
    }

    public double getValueBid() {
        return valueBid;
    }

    public void setValueBid(double valueBid) {
        this.valueBid = valueBid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
