package com.java.banve.service.impl;

import com.java.banve.entity.Xe;
import com.java.banve.model.XeDTO;
import com.java.banve.repository.LoaiRepository;
import com.java.banve.repository.XeRepository;
import com.java.banve.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XeServiceImpl implements XeService {

    @Autowired
    XeRepository xeRepository;
    @Autowired
    LoaiRepository loaiRepository;

    @Override
    public void themXe(XeDTO xeDTO) {
        Xe xe = new Xe();
        xe.setTen(xeDTO.getTen());
        xe.setStatus(true);
        xe.setSoghe(xeDTO.getSoghe());
        xe.setTrangthai(xeDTO.getTrangthai());
        xe.setLoai(this.loaiRepository.findById(Integer.parseInt(xeDTO.getLoai())).get());
        this.xeRepository.save(xe);
    }

    @Override
    public void suaXe(XeDTO xeDTO) {
        Xe xe = new Xe();
        xe.setId(xeDTO.getId());
        xe.setTen(xeDTO.getTen());
        xe.setSoghe(xeDTO.getSoghe());
        xe.setStatus(true);
        xe.setLoai(this.loaiRepository.findById(Integer.parseInt(xeDTO.getLoai())).get());
        xe.setTrangthai(xeDTO.getTrangthai());
        xeRepository.save(xe);
    }

    @Override
    public void xoaXe(Integer id){
        Xe xe = xeRepository.findById(id).get();
        xe.setStatus(false);
        xeRepository.save(xe);
    }

    @Override
    public Xe timXe(Integer id) {
        Optional<Xe> xe = this.xeRepository.findById(id);
        return xe.get();
    }

    @Override
    public XeDTO timXeDTO(Integer id) {
        Xe xe = new Xe();
        xe = timXe(id);
        XeDTO xeDTO = new XeDTO();
        xeDTO.setId(xe.getId());
        xeDTO.setTen(xe.getTen());
        xeDTO.setSoghe(xe.getSoghe());
        xeDTO.setLoai(String.valueOf(xe.getLoai().getId()));
        xeDTO.setTrangthai(xe.getTrangthai());
        return xeDTO;
    }

    @Override
    public List<Xe> tatCaXe() {
        return (List<Xe>) this.xeRepository.findAllByStatusEqualsTrue();
    }

    @Override
    public List<Xe> findXeLimit() {
        return this.xeRepository.findXeLimit();
    }

    @Override
    public List<Xe> findAllXeFree() {
        return this.xeRepository.findAllXeFree();
    }



}
