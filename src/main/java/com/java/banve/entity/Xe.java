package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "xe")
@Getter
@Setter

public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "soghe")
    private Integer soghe;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @ManyToOne
    @JoinColumn(name = "loai_id")
    private Loai loai;
    @OneToMany(mappedBy = "xe", fetch = FetchType.EAGER)
    private Collection<Chuyen> chuyen;
    @Column(name = "status")
    private Boolean status;
}
