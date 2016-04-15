package com.model.ResponseEntity;

import com.model.Event;
import com.model.User;
import java.time.LocalDateTime;

public class ResponseEvent {
    private int id;
    private String name;
    private String description;
    private User user;
    private String imageURL;
    private LocalDateTime date;


    public ResponseEvent(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.imageURL = event.getImageURL();
        this.date = event.getDate();
        this.user = event.getUser();
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }
}
