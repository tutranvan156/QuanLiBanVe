package com.java.banve.service.impl;

import com.java.banve.entity.Loai;
import com.java.banve.model.LoaiDTO;
import com.java.banve.repository.LoaiRepository;
import com.java.banve.service.LoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class LoaiServiceImpl implements LoaiService {

    @Autowired
    LoaiRepository loaiRepository;

    @Override
    public void themLoai(LoaiDTO loaiDTO) throws ParseException {
        loaiDTO.setStatus(true);
        Loai loai = new Loai();
        loai.setId(loaiDTO.getId());
        loai.setGia(loaiDTO.getGia());
        loai.setStatus(true);
        loai.setTen(loaiDTO.getTen());
        loai.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(loaiDTO.getDate()));
        this.loaiRepository.save(loai);
    }

    @Override
    public void suaLoai(LoaiDTO loaiDTO) throws ParseException {

        Loai loai = loaiRepository.findById(loaiDTO.getId()).get();
        loai.setTen(loaiDTO.getTen());
        loai.setGia(loaiDTO.getGia());
        loai.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(loaiDTO.getDate()));
        loaiRepository.save(loai);

    }

    @Override
    public void xoaLoai(Integer id) {
        Loai loai = loaiRepository.findById(id).get();
        loai.setStatus(false);
        loaiRepository.save(loai);
    }

    @Override
    public Loai timLoai(Integer id) {
        Optional<Loai> loai = this.loaiRepository.findById(id);
        return loai.get();
    }

    @Override
    public LoaiDTO timLoaiDTO(Integer id) {
        Loai loai = loaiRepository.findById(id).get();
        LoaiDTO loaiDTO = new LoaiDTO();
        loaiDTO.setId(loai.getId());
        loaiDTO.setDate(new SimpleDateFormat("yyyy-MM-dd").format(loai.getDate()));
        loaiDTO.setGia(loai.getGia());
        loaiDTO.setTen(loai.getTen());
        loaiDTO.setStatus(loai.getStatus());
        return loaiDTO;
    }

    @Override
    public List<Loai> tatCaLoai() {
        return (List<Loai>) this.loaiRepository.findAllByStatusEqualsTrue();
    }

    @Override
    public List<Loai> findLoaiLimit() {
        return this.loaiRepository.findLoaiLimit();
    }
}
