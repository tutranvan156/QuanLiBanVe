package com.java.banve.service.impl;

import com.java.banve.entity.Xe;
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

    @Override
    public void themXe(Xe xe) {
        this.xeRepository.save(xe);
    }

    @Override
    public Xe suaXe(Xe xe) {

        Integer id = xe.getId();
        Xe xeTemp = timXe(id);
        xeTemp.setTen(xe.getTen());
        xeTemp.setSoghe(xe.getSoghe());
        xeTemp.setChuyen(xe.getChuyen());
        xeTemp.setTrangthai(xe.getTrangthai());
        xeTemp.setLoai(xe.getLoai());
        return this.xeRepository.save(xeTemp);
    }

    @Override
    public void xoaXe(Integer id) {
        this.xeRepository.deleteById(id);
    }

    @Override
    public Xe timXe(Integer id) {
        Optional<Xe> xe = this.xeRepository.findById(id);
        return xe.get();
    }

    @Override
    public List<Xe> tatCaXe() {
        return (List<Xe>) this.xeRepository.findAll();

    }
}
