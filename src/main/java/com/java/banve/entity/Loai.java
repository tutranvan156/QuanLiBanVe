package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "loai")
@Getter
@Setter
public class Loai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gia")
    private Integer gia;
    @Column(name = "ngay")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "loai", fetch = FetchType.EAGER)
    private Collection<Xe> xes;




}
