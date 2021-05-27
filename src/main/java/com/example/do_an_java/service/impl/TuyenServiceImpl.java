package com.example.do_an_java.service.impl;

import com.example.do_an_java.entity.Tuyen;
import com.example.do_an_java.repository.TuyenRepository;
import com.example.do_an_java.service.TuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuyenServiceImpl implements TuyenService {

    @Autowired
    TuyenRepository tuyenRepository;

    @Override
    public void themTuyenXe(Tuyen tuyen) {
        this.tuyenRepository.save(tuyen);
    }

    @Override
    public Tuyen suaTuyenXe(Tuyen tuyen) {

        Integer id = tuyen.getId();
        Tuyen tuyenTemp = timTuyen(id);
        tuyenTemp.setId(id);
        tuyenTemp.setTentuyen(tuyen.getTentuyen());
        tuyenTemp.setGio(tuyen.getGio());
        return this.tuyenRepository.save(tuyenTemp);
    }

    @Override
    public void xoaTuyenXe(Integer id) {
        this.tuyenRepository.deleteById(id);
    }

    @Override
    public Tuyen timTuyen(Integer id) {
        Optional<Tuyen> tuyen = this.tuyenRepository.findById(id);
        return tuyen.get();
    }

    @Override
    public List<Tuyen> tatCaTuyenXe() {
        return (List<Tuyen>) this.tuyenRepository.findAll();

    }
}
