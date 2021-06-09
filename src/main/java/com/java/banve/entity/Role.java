package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Role() {

    }
}
