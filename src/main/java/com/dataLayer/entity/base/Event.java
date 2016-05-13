package com.dataLayer.entity.base;

import com.dataLayer.entity.DTO.eventDTO.RequestEventDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity(name = "event")
public class Event extends com.dataLayer.entity.base.Entity {
    @Column
    private String name;
    @Column
    private LocalDateTime date;
    @Column(name = "split_bill_id")
    private Integer splitBillId;
    @OneToOne
    private User user;

    public Event(LocalDateTime date, String name) {
        this.date = date;
        this.name = name;
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

    public Integer getSplitBillId() {
        return splitBillId;
    }

    public void setSplitBillId(Integer splitBillId) {
        this.splitBillId = splitBillId;
    }
}

