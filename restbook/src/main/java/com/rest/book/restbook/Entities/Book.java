package com.rest.book.restbook.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String author;
    @OneToOne(cascade=CascadeType.ALL)
    @JsonManagedReference
    private Publish publish;
    @Override
    
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", title=" + title + "]";
    }
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public Book() {
 
    }
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
    

    /**
     * @return Publish return the publish
     */
    public Publish getPublish() {
        return publish;
    }

    /**
     * @param publish the publish to set
     */
    public void setPublish(Publish publish) {
        this.publish = publish;
    }

}
