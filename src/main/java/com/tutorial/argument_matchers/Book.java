package com.tutorial.argument_matchers;

import java.time.LocalDate;

public class Book {

    private String bookId;
    private String title;
    private int price;
    private LocalDate publishDate;
    private boolean isDigital;


    public Book() {
    }

    public Book(String bookId, String title, int price, LocalDate publishDate, boolean isDigital) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
        this.isDigital = isDigital;
    }

    public Book(String s, String mockito, int i, LocalDate now) {
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
