package com.java.banve.service;

import com.java.banve.entity.Ve;
import com.java.banve.model.SearchListVeDTO;
import com.java.banve.model.VeDTO;

import java.util.List;

public interface VeService {
    void themVe(Ve ve);
    Ve timVe(Integer id);
    Ve suaVe(Ve ve);
    void xoaVe(Integer id);
    List<Ve> tatCaVe();
    VeDTO timVeDTO(Integer id);
    List<VeDTO> tatCaVeChuaDuyet();
    void xacNhanVe(Integer id);
    List<VeDTO> convert(List<Ve> list);

    List<Ve> findAllVeByUserID(Integer id);
    List<Ve> findAllVeByUsername(String username);
}
