package com.java.banve.service;

import com.java.banve.entity.Loai;

import java.util.List;

public interface LoaiService {

    List<Loai> tatCaLoai();

    void themLoai(Loai loai);

    Loai suaLoai(Loai loai);

    void xoaLoai(Integer id);

    Loai timLoai(Integer id);
}
