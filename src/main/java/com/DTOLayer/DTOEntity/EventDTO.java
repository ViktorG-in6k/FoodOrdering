package com.DTOLayer.DTOEntity;

import com.model.Entity.Event;
import com.model.Entity.User;
import java.time.LocalDateTime;

public class EventDTO {
    protected int id;
    protected String name;
    protected String description;
    protected User user;
    protected String imageURL;
    protected LocalDateTime date;

    public EventDTO(Event event) {
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
