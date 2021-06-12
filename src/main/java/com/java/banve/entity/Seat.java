package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private Integer code;

    @OneToOne(mappedBy = "seat")
    private Ve ve;

    @ManyToOne
    @JoinColumn(name = "chuyen_id")
    private Chuyen chuyen;

    @Column(name = "status")
    private Boolean status;
}
