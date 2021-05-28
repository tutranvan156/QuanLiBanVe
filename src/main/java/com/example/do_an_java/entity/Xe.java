package com.example.do_an_java.entity;

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

    @ManyToOne
    @JoinColumn(name = "maloai")
    private Loai loai;


    @Column(name = "trangthai")
    private Boolean trangthai;

    @OneToMany(mappedBy = "xe", fetch = FetchType.EAGER)
    private Collection<Chuyen> chuyen;
}
