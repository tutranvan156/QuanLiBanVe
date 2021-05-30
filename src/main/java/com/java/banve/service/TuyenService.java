package com.java.banve.service;

import com.java.banve.entity.Tuyen;

import java.util.List;

public interface TuyenService {
    void themTuyenXe(Tuyen tuyen);
    Tuyen timTuyen(Integer id);
    Tuyen suaTuyenXe(Tuyen tuyen);
    void xoaTuyenXe(Integer id);
    List<Tuyen> tatCaTuyenXe();
}
