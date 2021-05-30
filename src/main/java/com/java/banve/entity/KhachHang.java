package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "khachhang", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
@Getter
@Setter
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ho")
    private String ho;
    @Column(name = "ten")
    private String ten;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "email")
    private String email;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "khachHang", fetch = FetchType.EAGER)
    private Collection<Ve> ves;
}
