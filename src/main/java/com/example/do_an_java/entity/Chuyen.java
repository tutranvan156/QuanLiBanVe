package com.example.do_an_java.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "matuyen")
    private Tuyen tuyen;
    @ManyToOne
    @JoinColumn(name = "maxe")
    private Xe xe;

    @OneToMany(mappedBy = "chuyen", fetch = FetchType.EAGER)
    private Collection<Ve> ves;


}
