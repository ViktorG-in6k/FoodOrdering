package com.model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "status")
public class Status extends com.model.base.Entity {
    @Column(name = "name", nullable = false)
    private String name;
}
