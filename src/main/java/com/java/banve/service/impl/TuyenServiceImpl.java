package com.java.banve.service.impl;

import com.java.banve.entity.Tuyen;
import com.java.banve.model.TuyenDTO;
import com.java.banve.repository.TuyenRepository;
import com.java.banve.service.TuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public TuyenDTO timTuyenDTO(Integer id) {
        Tuyen tuyen = this.tuyenRepository.findById(id).get();
        TuyenDTO tuyenDTO = new TuyenDTO();
        tuyenDTO.setId(tuyen.getId());
        tuyenDTO.setTenTuyen(tuyen.getTentuyen());
        tuyenDTO.setGio(new SimpleDateFormat("hh:mm").format(tuyen.getGio()));
        return tuyenDTO;
    }

    @Override
    public void suaTuyenDTO(TuyenDTO tuyenDTO) throws ParseException {
        Tuyen tuyen = this.tuyenRepository.findById(tuyenDTO.getId()).get();
        tuyen.setTentuyen(tuyenDTO.getTenTuyen());
        tuyen.setGio(new SimpleDateFormat("hh:mm").parse(tuyenDTO.getGio()));
        this.tuyenRepository.save(tuyen);
    }

    @Override
    public void themTuyenDTO(TuyenDTO tuyenDTO) throws ParseException {
        Tuyen tuyen = new Tuyen();
        tuyen.setId(tuyenDTO.getId());
        tuyen.setTentuyen(tuyenDTO.getTenTuyen());
        tuyen.setGio(new SimpleDateFormat("hh:mm").parse(tuyenDTO.getGio()));
        tuyen.setStatus(true);
        this.tuyenRepository.save(tuyen);
    }

    @Override
    public Boolean isTuyenExisted(TuyenDTO tuyenDTO) throws ParseException {
        List<Tuyen> temp = this.tuyenRepository.findAllByTentuyen(tuyenDTO.getTenTuyen());
        Date tempDate = new SimpleDateFormat("hh:mm").parse(tuyenDTO.getGio());
        for (Tuyen item: temp) {
           if (item.getGio().equals(tempDate)) {
               return true;
           }
        }
        return false;
    }
}
