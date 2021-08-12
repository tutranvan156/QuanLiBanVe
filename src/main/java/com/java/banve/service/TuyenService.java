package com.java.banve.service;

import com.java.banve.entity.Tuyen;
import com.java.banve.model.TuyenDTO;

import java.text.ParseException;
import java.util.List;

public interface TuyenService {
    void themTuyenXe(Tuyen tuyen);
    Tuyen timTuyen(Integer id);
    Tuyen suaTuyenXe(Tuyen tuyen);
    void xoaTuyenXe(Integer id);
    List<Tuyen> tatCaTuyenXe();
    List<Tuyen> findTuyenLimit();
    TuyenDTO timTuyenDTO(Integer id);
    void suaTuyenDTO(TuyenDTO tuyenDTO) throws ParseException;
    void themTuyenDTO(TuyenDTO tuyenDTO) throws ParseException;
    Boolean isTuyenExisted(TuyenDTO tuyenDTO) throws ParseException;
    Boolean isTuyenExistedUpdate(TuyenDTO tuyenDTO) throws ParseException;

}
