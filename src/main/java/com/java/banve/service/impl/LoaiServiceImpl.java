package com.java.banve.service.impl;

import com.java.banve.entity.Loai;
import com.java.banve.repository.LoaiRepository;
import com.java.banve.service.LoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoaiServiceImpl implements LoaiService {

    @Autowired
    LoaiRepository loaiRepository;

    @Override
    public void themLoai(Loai loai) {
        this.loaiRepository.save(loai);
    }

    @Override
    public Loai suaLoai(Loai loai) {

        Integer id = loai.getId();
        Loai loaiTemp = timLoai(id);
        loaiTemp.setId(id);
        loaiTemp.setTen(loai.getTen());
        loaiTemp.setDate(loai.getDate());
        loaiTemp.setGia(loai.getGia());
        return this.loaiRepository.save(loaiTemp);
    }

    @Override
    public void xoaLoai(Integer id) {
        this.loaiRepository.deleteById(id);
    }

    @Override
    public Loai timLoai(Integer id) {
        Optional<Loai> loai = this.loaiRepository.findById(id);
        return loai.get();
    }

    @Override
    public List<Loai> tatCaLoai() {
        return (List<Loai>) this.loaiRepository.findAll();
    }
}
