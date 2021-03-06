package com.hhu.entity;

/**
 * Created by WeiguoLiu on 2018/3/3.
 */
public class StudentBook {
    private Integer id;
    private String bookName;
    private String isbn;
    private int price;
    private int stock;

    @Override
    public String toString() {
        return "StudentBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
