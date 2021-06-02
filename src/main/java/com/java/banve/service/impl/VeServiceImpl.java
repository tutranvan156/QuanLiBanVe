package com.java.banve.service.impl;

import com.java.banve.entity.Ve;
import com.java.banve.repository.VeRepository;
import com.java.banve.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VeServiceImpl implements VeService {
    @Autowired
    VeRepository veRepository;

    @Override
    public void themVe(Ve ve) {
        this.veRepository.save(ve);
    }

    @Override
    public Ve suaVe(Ve ve) {

        Integer id = ve.getId();
        Ve veTemp = timVe(id);
        ///set ve chua lam
//        chuyenTemp.setDate(chuyen.getDate());
        return this.veRepository.save(veTemp);
    }

    @Override
    public void xoaVe(Integer id) {
        this.veRepository.deleteById(id);
    }

    @Override
    public Ve timVe(Integer id) {
        Optional<Ve> ve = this.veRepository.findById(id);
        return ve.get();
    }

    @Override
    public List<Ve> tatCaVe() {
        return (List<Ve>) this.veRepository.findAll();
    }
}
