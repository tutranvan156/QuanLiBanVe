package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "chuyen")
@Getter
@Setter
public class Chuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ngay")
    private String date;
    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "tuyen_id")
    private Tuyen tuyen;
    @ManyToOne
    @JoinColumn(name = "xe_id")
    private Xe xe;

    @OneToMany(mappedBy = "chuyen", fetch = FetchType.EAGER)
    private Collection<Ve> ves;


}
