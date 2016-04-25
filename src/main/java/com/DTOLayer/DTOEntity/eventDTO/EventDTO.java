package com.DTOLayer.DTOEntity.eventDTO;

import com.DTOLayer.DTOEntity.userDTO.UserDTO;
import com.model.Entity.Event;
import com.model.Entity.User;

import java.time.LocalDateTime;

public class EventDTO {
    private int id;
    private String name;
    private String description;
    private User user;
    private UserDTO sessionUser;
    private String imageURL;
    private LocalDateTime date;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.imageURL = event.getImageURL();
        this.date = event.getDate();
        this.user = event.getUser();


    }

    public EventDTO(Event event, User user) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.imageURL = event.getImageURL();
        this.date = event.getDate();
        this.user = event.getUser();
        this.sessionUser = new UserDTO(user);
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

    public UserDTO getSessionUser() {
        return sessionUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSessionUser(UserDTO sessionUser) {
        this.sessionUser = sessionUser;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

