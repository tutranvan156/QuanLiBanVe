package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

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
    private BigDecimal gia;
    @Column(name = "ngay")
    private String date;
    @OneToMany(mappedBy = "loai", fetch = FetchType.EAGER)
    private Collection<Xe> xes;




}
