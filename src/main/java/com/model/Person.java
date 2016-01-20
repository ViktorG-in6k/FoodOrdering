package com.model;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(appliesTo = "Person")
public class Person extends com.model.base.Entity {

    @Column
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
