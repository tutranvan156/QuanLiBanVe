package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tuyen")
@Getter
@Setter
public class Tuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tentuyen")
    private String tentuyen;
    @Column(name = "status")
    private Boolean status;


    @Column(name = "gio")
    private String gio;
    @OneToMany(mappedBy = "tuyen", fetch = FetchType.EAGER)
    private Collection<Chuyen> chuyens;





}
