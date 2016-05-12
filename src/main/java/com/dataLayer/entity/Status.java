package com.dataLayer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "status")
public class Status extends com.dataLayer.entity.base.Entity {
    @Column(name = "name", nullable = false)
    private String name;

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

