package com.shortn0tes.feignexample.model.exmo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ExmoObject {
    private Book book;

    public ExmoObject(Book book) {
        this.book = book;
    }

    public ExmoObject() {
    }

    public Book getBook() {
        return book;
    }

    @JsonSetter("KICK_BTC")
    public void setBook(Book book) {
        this.book = book;
    }
}
