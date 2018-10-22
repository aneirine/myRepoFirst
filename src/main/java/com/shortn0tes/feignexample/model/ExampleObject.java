package com.shortn0tes.feignexample.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ExampleObject {
    private Book book;

    public ExampleObject() {
    }

    public Book getBook() {
        return book;
    }

    @JsonSetter("ETH_BTC")
    public void setBook(Book book) {
        this.book = book;
    }
}
