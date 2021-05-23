package com.example.bookservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Books")
@Table(name = "BOOKS")
public class Book {

    @Id
    @Column(name = "id")
    Long id;

	@Column(name = "title", nullable = false)
	String title;

	@Column(name = "author", nullable = false)
	String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
