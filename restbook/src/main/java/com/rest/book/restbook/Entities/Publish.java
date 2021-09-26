package com.rest.book.restbook.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Publish {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="pub_id")
    private int publishId;
    @Column(name="pub_month")
    private String publish_month;
    @Column(name="pub_year")
    private int publish_year;
    @OneToOne(mappedBy="publish")
    @JsonBackReference
    private Book book;
    

    public Publish() {
    }


    /**
     * @return int return the publishId
     */
    public int getPublishId() {
        return publishId;
    }

    /**
     * @param publishId the publishId to set
     */
    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    /**
     * @return String return the publish_month
     */
    public String getPublish_month() {
        return publish_month;
    }

    /**
     * @param publish_month the publish_month to set
     */
    public void setPublish_month(String publish_month) {
        this.publish_month = publish_month;
    }

    /**
     * @return int return the publish_year
     */
    public int getPublish_year() {
        return publish_year;
    }

    /**
     * @param publish_year the publish_year to set
     */
    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }


    /**
     * @return Book return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

}