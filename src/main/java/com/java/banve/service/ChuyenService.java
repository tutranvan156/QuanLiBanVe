package com.java.banve.service;

import com.java.banve.entity.Chuyen;

import java.util.List;

public interface ChuyenService {

    List<Chuyen> tatCaChuyen();

    void themChuyen(Chuyen chuyen);

    Chuyen suaChuyen(Chuyen chuyen);

    void xoaChuyen(Integer id);

    Chuyen timChuyen(Integer id);
}
