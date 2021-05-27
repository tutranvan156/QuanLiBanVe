package com.example.do_an_java.service;

import com.example.do_an_java.entity.Loai;
import com.example.do_an_java.entity.Xe;

import java.util.List;

public interface XeService {

    List<Xe> tatCaXe();

    void themXe(Xe xe);

    Xe suaXe(Xe xe);

    void xoaXe(Integer id);

    Xe timXe(Integer id);
}
