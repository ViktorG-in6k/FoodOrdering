package com.model.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @OneToOne
    private User user;

    public Event(String name, String description, String imageURL, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.date = date;
    }

    public Event() {}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
