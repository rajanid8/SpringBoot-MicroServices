package com.microservices.bookcatalogservice.model;

public class BookCatalog {

    private String bookName;
    private String bookDesc;
    private int bookRating;

    public BookCatalog() {
    }

    public BookCatalog(String bookName, String bookDesc, int bookRating) {
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.bookRating = bookRating;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }
}
