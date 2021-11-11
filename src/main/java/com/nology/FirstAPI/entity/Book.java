package com.nology.FirstAPI.entity;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Validated
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    private String publisher;

    private int pubDate;

    // CAN'T REMEMBER WHAT THE IMPORTANCE OF A BEAN IS??

    public Book() {
    }

    public Book(int id, String title, String author, String publisher, int pubDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
    }
    // ---> noticed you can't change attributes once you've created a database entry

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPubDate() {
        return pubDate;
    }

    public void setPubDate(int pubDate) {
        this.pubDate = pubDate;
    }
}
