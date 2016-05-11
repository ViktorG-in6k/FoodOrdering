package com.model.Entity;

import javax.persistence.*;

@Entity(name = "user")
public class User extends com.model.base.Entity {
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column
    private String name;
    @Column
    private String familyName;
    @Column
    private String picture;
    @Column
    private String gender;

    public User() {
    }

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = "aaa";
    }

    public User(String email) {
        this.email = email;
        this.password = "aaa";
    }

    public User(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setName(user.getName());
        this.setFamilyName(user.getFamilyName());
        this.setPicture(user.getPicture());
        this.setGender(user.getGender());
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

