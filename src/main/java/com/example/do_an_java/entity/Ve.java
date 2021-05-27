package com.example.do_an_java.entity;

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
    @JoinColumn(name = "makhach")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "machuyen")
    private Chuyen chuyen;
    @Column(name = "vitri")
    private String vitri;


}
