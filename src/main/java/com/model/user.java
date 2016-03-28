package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class user extends com.model.base.Entity {

    @Column
    private String name;

    @Column
    private String email;

    public user(String name) {
        this.name = name;
    }

    public user() {
    }

    public user(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
