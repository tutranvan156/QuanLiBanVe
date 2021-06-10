package com.java.banve.service.impl;

import com.java.banve.entity.Tuyen;
import com.java.banve.repository.TuyenRepository;
import com.java.banve.service.TuyenService;
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
        tuyen.setStatus(true);
        this.tuyenRepository.save(tuyen);
    }

    @Override
    public Tuyen suaTuyenXe(Tuyen tuyen) {

        Integer id = tuyen.getId();
        Tuyen tuyenTemp = timTuyen(id);
        tuyenTemp.setId(id);
        tuyenTemp.setStatus(true);
        tuyenTemp.setTentuyen(tuyen.getTentuyen());
        tuyenTemp.setGio(tuyen.getGio());
        return this.tuyenRepository.save(tuyenTemp);
    }

    @Override
    public void xoaTuyenXe(Integer id) {
        Tuyen tuyen = tuyenRepository.findById(id).get();
        tuyen.setStatus(false);
        this.tuyenRepository.save(tuyen);
    }

    @Override
    public Tuyen timTuyen(Integer id) {
        Optional<Tuyen> tuyen = this.tuyenRepository.findById(id);
        return tuyen.get();
    }

    @Override
    public List<Tuyen> tatCaTuyenXe() {
        return (List<Tuyen>) this.tuyenRepository.findAllByStatusEqualsTrue();

    }

    @Override
    public List<Tuyen> findTuyenLimit() {
        return this.tuyenRepository.findTuyenLimit();
    }
}
