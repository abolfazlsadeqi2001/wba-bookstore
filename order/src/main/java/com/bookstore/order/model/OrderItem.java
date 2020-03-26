package com.bookstore.order.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Embedded
    private BookInfo book;
    @Column(nullable = false)
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(BookInfo book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public BookInfo getBook() {
        return book;
    }

    public void setBook(BookInfo book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
