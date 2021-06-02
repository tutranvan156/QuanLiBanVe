package com.java.banve.service;

import com.java.banve.entity.Ve;

import java.util.List;

public interface VeService {
    void themVe(Ve ve);
    Ve timVe(Integer id);
    Ve suaVe(Ve ve);
    void xoaVe(Integer id);
    List<Ve> tatCaVe();
}
