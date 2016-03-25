package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class user extends com.model.base.Entity {

    @Column
    private String name;

    public user(String name) {
        this.name = name;
    }

    public user() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
