package com.example.restaurant1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@javax.persistence.Table(name = "table")
@DynamicUpdate
public class Table {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
