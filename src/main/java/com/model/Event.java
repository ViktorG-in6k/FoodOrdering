package com.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity(name = "event")
public class Event extends com.model.base.Entity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String imageURL;

    @Column
    private LocalDateTime date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "order_list",
            joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") })
    private List<Menu> itemsList;

    public Event(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public Event(String name, String description, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Event(String name, String description, String imageURL, LocalDateTime date) {

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Menu> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Menu> itemsList) {
        this.itemsList = itemsList;
    }
}