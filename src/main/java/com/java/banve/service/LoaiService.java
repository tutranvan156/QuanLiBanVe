package com.java.banve.service;

import com.java.banve.entity.Loai;
import com.java.banve.model.LoaiDTO;

import java.text.ParseException;
import java.util.List;

public interface LoaiService {

    List<Loai> tatCaLoai();
    void themLoai(LoaiDTO loaiDTO) throws ParseException;


    void suaLoai(LoaiDTO loaiDTO) throws ParseException;

    void xoaLoai(Integer id);

    Loai timLoai(Integer id);
    LoaiDTO timLoaiDTO(Integer id);
    List<Loai> findLoaiLimit();
}
