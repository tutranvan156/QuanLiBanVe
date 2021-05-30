package com.java.banve.service;

import com.java.banve.entity.Xe;

import java.util.List;

public interface XeService {

    List<Xe> tatCaXe();

    void themXe(Xe xe);

    Xe suaXe(Xe xe);

    void xoaXe(Integer id);

    Xe timXe(Integer id);
}
