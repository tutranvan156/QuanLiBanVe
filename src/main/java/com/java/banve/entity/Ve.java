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
//    @ManyToOne
//    @JoinColumn(name = "chuyen_id")
//    private Chuyen chuyen;
    @Column(name = "diemdi")
    private String diemDi;
    @Column(name = "diemden")
    private String diemDen;
    @Column(name = "status")
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;


}
