package com.hibernateproject.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    public static final long serialVersionUUID = 10L;


    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_sequence")
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
