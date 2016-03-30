package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity(name = "restaurant")
public class Restaurant extends com.model.base.Entity {


    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String imageURL;

    public Restaurant(String name, LocalDateTime date) {
        this.name = name;
    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Restaurant(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;

    }

    public Restaurant() {
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


}