package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="book_title")
    @NotNull
    private String title;

    @Column(name ="isbin")
    @NotNull
    private String isbin;

    @Column(name ="authors")
    @NotNull
    private String authors;

    @Column(name ="publish_date")
    @NotNull
    private Date publishDate;

    @Column(name ="publisher")
    @NotNull
    private String publisher;

    @Column(name ="price")
    @NotNull
    private Double price;

    @Column(name ="stock")
    @NotNull
    private Integer stock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbin() {
        return isbin;
    }

    public void setIsbin(String isbin) {
        this.isbin = isbin;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
