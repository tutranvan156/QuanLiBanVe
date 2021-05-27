package com.example.do_an_java.service.impl;

import com.example.do_an_java.entity.Chuyen;
import com.example.do_an_java.entity.Xe;
import com.example.do_an_java.repository.ChuyenRepository;
import com.example.do_an_java.repository.XeRepository;
import com.example.do_an_java.service.ChuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ChuyenServiceImpl implements ChuyenService {
    @Autowired
    ChuyenRepository chuyenRepository;

    @Override
    public void themChuyen(Chuyen chuyen) {
        this.chuyenRepository.save(chuyen);
    }

    @Override
    public Chuyen suaChuyen(Chuyen chuyen) {

        Integer id = chuyen.getId();
        Chuyen chuyenTemp = timChuyen(id);
        chuyenTemp.setId(id);
        chuyenTemp.setDate(chuyen.getDate());
        chuyenTemp.setXe(chuyen.getXe());
        chuyenTemp.setTuyen(chuyen.getTuyen());
        return this.chuyenRepository.save(chuyenTemp);
    }

    @Override
    public void xoaChuyen(Integer id) {
        this.chuyenRepository.deleteById(id);
    }

    @Override
    public Chuyen timChuyen(Integer id) {
        Optional<Chuyen> chuyen = this.chuyenRepository.findById(id);
        return chuyen.get();
    }

    @Override
    public List<Chuyen> tatCaChuyen() {
        return (List<Chuyen>) this.chuyenRepository.findAll();
    }
}
