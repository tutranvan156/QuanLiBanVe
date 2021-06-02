package com.java.banve.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
public class ChuyenDTO {

    private Integer id;
    private String date;
    private String tuyen;
    private String xe;
    private String tenTuyen;
    private String tenXe;
    private Integer gia;
    private Integer ghe;
}
