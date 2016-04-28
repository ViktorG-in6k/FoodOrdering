package com.model.Entity;

import com.DTOLayer.DTOEntity.RequestEventDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity(name = "event")
public class Event extends com.model.base.Entity {
    @Column
    private String name;
    @Column
    private LocalDateTime date;
    @OneToOne
    private User user;

    public Event(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public Event(RequestEventDTO eventDTO) {
        this.name = eventDTO.getName();
        this.date = eventDTO.getDate();
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

