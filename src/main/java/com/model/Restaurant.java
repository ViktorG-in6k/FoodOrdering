package com.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "restaurant")
public class Restaurant extends com.model.base.Entity {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String imageURL;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Item> item;

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

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public void addToMenu(Item item) {
        this.item.add(item);
    }
}
