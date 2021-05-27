package com.example.do_an_java.service;

import com.example.do_an_java.entity.Tuyen;

import java.util.List;
import java.util.Optional;

public interface TuyenService {
    void themTuyenXe(Tuyen tuyen);
    Tuyen timTuyen(Integer id);
    Tuyen suaTuyenXe(Tuyen tuyen);
    void xoaTuyenXe(Integer id);
    List<Tuyen> tatCaTuyenXe();
}
