package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user")
public class User extends com.model.base.Entity {

    @Column
    private String name;


//    @Column(unique=true)
//    private String username;
//    private String password;
//    @OneToOne(mappedBy="user", cascade={CascadeType.ALL})
//    private Role role;



    @Column
    private String email;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String name, String email) {
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

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
