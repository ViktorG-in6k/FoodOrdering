package com.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

import static java.awt.font.TransformAttribute.IDENTITY;

@Entity
@Table(name = "user_roles")
public class UserRole extends com.model.base.Entity {

    public enum Role {ROLE_ADMIN, ROLE_USER}


    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}