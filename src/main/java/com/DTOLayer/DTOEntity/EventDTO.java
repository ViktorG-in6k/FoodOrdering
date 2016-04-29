package com.DTOLayer.DTOEntity;

import com.model.Entity.Event;
import com.model.Entity.User;

import java.time.LocalDateTime;

public class EventDTO {
    private int id;
    private String name;
    private User user;
    private UserDTO sessionUser;
    private LocalDateTime date;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.user = event.getUser();
    }

    public EventDTO(Event event, User user) {
        this.id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.user = event.getUser();
        this.sessionUser = new UserDTO(user);
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setSessionUser(UserDTO sessionUser) {
        this.sessionUser = sessionUser;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

