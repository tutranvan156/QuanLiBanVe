package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ve")
@Getter
@Setter
public class Ve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "chuyen_id")
    private Chuyen chuyen;
    @Column(name = "vitri")
    private String vitri;
    @Column(name = "status")
    private Boolean status;


}
