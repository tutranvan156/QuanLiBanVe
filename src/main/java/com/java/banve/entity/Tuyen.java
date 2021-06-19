package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

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
    @Temporal(TemporalType.TIME)
    private Date gio;
    @OneToMany(mappedBy = "tuyen", fetch = FetchType.EAGER)
    private Collection<Chuyen> chuyens;





}
