package com.java.banve.service.impl;

import com.java.banve.entity.Ve;
import com.java.banve.model.VeDTO;
import com.java.banve.repository.VeRepository;
import com.java.banve.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
        return this.veRepository.save(veTemp);
    }

    @Override
    public void xoaVe(Integer id) {
        Ve ve = veRepository.findById(id).get();
        ve.setStatus(false);

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

    @Override
    public VeDTO timVeDTO(Integer id) {
        Ve ve = this.veRepository.findById(id).get();
        VeDTO veDTO = new VeDTO();
        veDTO.setId(ve.getId());
        veDTO.setFullName(ve.getUser().getHo() + " " + ve.getUser().getTen());
        veDTO.setDiemDen(ve.getDiemDen());
        veDTO.setDiemDi(ve.getDiemDi());
        veDTO.setMaGhe(ve.getSeat().getCode());
        veDTO.setGia(ve.getSeat().getChuyen().getXe().getLoai().getGia());
        return veDTO;


    }


    @Override
    public List<VeDTO> tatCaVeChuaDuyet() {
        List<Ve> ve =  this.veRepository.findAllVeChuaDuyet();
        return convert(ve);

    }

    @Override
    public void xacNhanVe(Integer id) {
        Ve ve = timVe(id);
        ve.setStatus(false);
        this.veRepository.save(ve);
    }

    @Override
    public List<VeDTO> convert(List<Ve> list) {
        Ve ve = new Ve();
        List<VeDTO> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            VeDTO veDTO = new VeDTO();
            ve = list.get(i);
            veDTO.setId(ve.getId());
            veDTO.setFullName(ve.getUser().getHo() + " " + ve.getUser().getTen());
            veDTO.setDiemDen(ve.getDiemDen());
            veDTO.setDiemDi(ve.getDiemDi());
            veDTO.setMaGhe(ve.getSeat().getCode());
            veDTO.setGia(ve.getSeat().getChuyen().getXe().getLoai().getGia());
            veDTO.setNgay(new SimpleDateFormat("yyyy-MM-dd").format(ve.getSeat().getChuyen().getDate()));
            temp.add(veDTO);
        }
        return temp;
    }
}
