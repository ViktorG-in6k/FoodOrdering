package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;


@Entity(name = "event")
public class Event extends com.model.base.Entity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String imageURL;

    @Column
    private LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
    public Event(String name, String description, LocalDate date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }
    public Event(String name, String description, String imageURL, LocalDate date) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.date = date;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}