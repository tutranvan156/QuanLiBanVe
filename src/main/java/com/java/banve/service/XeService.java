package com.java.banve.service;

import com.java.banve.entity.Xe;
import com.java.banve.model.XeDTO;

import java.util.List;

public interface XeService {

    List<Xe> tatCaXe();


    void themXe(XeDTO xeDTO);

    void suaXe(XeDTO xeDTO);

    void xoaXe(Integer id);

    Xe timXe(Integer id);
    XeDTO timXeDTO(Integer id);
    List<Xe> findXeLimit();
    List<Xe> findAllXeFree();
    Boolean isXeExisted(XeDTO xeDTO);
}
