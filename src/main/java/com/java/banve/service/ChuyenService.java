package com.java.banve.service;

import com.java.banve.entity.Chuyen;
import com.java.banve.model.ChuyenDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.util.List;

public interface ChuyenService {

    List<Chuyen> tatCaChuyen();

    void themChuyen(ChuyenDTO chuyenDTO) throws ParseException;

    void suaChuyen(ChuyenDTO chuyenDTO) throws ParseException;

    void xoaChuyen(Integer id);

    Chuyen timChuyen(Integer id);
    ChuyenDTO timChuyenDTO(Integer id);
    List<Chuyen> findChuyenLimit();
    List<ChuyenDTO> listSearchChuyenDTO(String diemDi, String diemDen, String date) throws ParseException;
}
