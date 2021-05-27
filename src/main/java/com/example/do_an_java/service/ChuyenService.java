package com.example.do_an_java.service;

import com.example.do_an_java.entity.Chuyen;
import com.example.do_an_java.entity.Loai;

import java.util.List;

public interface ChuyenService {

    List<Chuyen> tatCaChuyen();

    void themChuyen(Chuyen chuyen);

    Chuyen suaChuyen(Chuyen chuyen);

    void xoaChuyen(Integer id);

    Chuyen timChuyen(Integer id);
}
