package com.java.banve.service.impl;

import com.java.banve.entity.Chuyen;
import com.java.banve.entity.Seat;
import com.java.banve.entity.Xe;
import com.java.banve.model.ChuyenDTO;
import com.java.banve.repository.ChuyenRepository;
import com.java.banve.repository.SeatRepository;
import com.java.banve.repository.TuyenRepository;
import com.java.banve.repository.XeRepository;
import com.java.banve.service.ChuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ChuyenServiceImpl implements ChuyenService {
    @Autowired
    ChuyenRepository chuyenRepository;
    @Autowired
    XeRepository xeRepository;
    @Autowired
    TuyenRepository tuyenRepository;

    @Autowired
    SeatRepository seatRepository;

    @Override
    public void themChuyen(ChuyenDTO chuyenDTO) throws ParseException {
        Chuyen chuyen = new Chuyen();
        chuyen.setStatus(true);
        chuyen.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(chuyenDTO.getDate()));
        chuyen.setXe(xeRepository.findById(Integer.parseInt(chuyenDTO.getXe())).get());
        chuyen.setTuyen(tuyenRepository.findById(Integer.parseInt(chuyenDTO.getTuyen())).get());
        this.chuyenRepository.save(chuyen);
        for (int i = 1; i <= chuyen.getXe().getSoghe(); i++ ) {
            Seat seat = new Seat();
            seat.setStatus(true);
            seat.setCode(i);
            seat.setChuyen(chuyen);
            seatRepository.save(seat);
        }
        Xe xe = chuyen.getXe();
        xe.setTrangthai(false);
        this.xeRepository.save(xe);
    }

    @Override
    public void suaChuyen(ChuyenDTO chuyenDTO) throws ParseException {
        Chuyen chuyen = chuyenRepository.findById(chuyenDTO.getId()).get();
        chuyen.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(chuyenDTO.getDate()));
        chuyen.setTuyen(tuyenRepository.findById(Integer.parseInt(chuyenDTO.getTuyen())).get());
        chuyen.setXe(xeRepository.findById(Integer.parseInt(chuyenDTO.getXe())).get());
        this.chuyenRepository.save(chuyen);
    }

    @Override
    public void xoaChuyen(Integer id) {
        Chuyen chuyen = chuyenRepository.findById(id).get();
        chuyen.setStatus(false);
        chuyenRepository.save(chuyen);
    }

    @Override
    public Chuyen timChuyen(Integer id) {
        Optional<Chuyen> chuyen = this.chuyenRepository.findById(id);
        return chuyen.get();
    }

    @Override
    public ChuyenDTO timChuyenDTO(Integer id) {
        Chuyen chuyen = timChuyen(id);
        ChuyenDTO chuyenDTO = new ChuyenDTO();
        chuyenDTO.setId(chuyen.getId());
        chuyenDTO.setGhe(chuyen.getXe().getSoghe());
        chuyenDTO.setGia(chuyen.getXe().getLoai().getGia());
        chuyenDTO.setXe(String.valueOf(chuyen.getXe().getId()));
        chuyenDTO.setTuyen(String.valueOf(chuyen.getTuyen().getId()));
        chuyenDTO.setDate(new SimpleDateFormat("yyyy-MM-dd").format(chuyen.getDate()));
        chuyenDTO.setTenTuyen(chuyen.getTuyen().getTentuyen());
        chuyenDTO.setTenXe(chuyen.getXe().getTen());
        return chuyenDTO;
    }

    @Override
    public List<Chuyen> tatCaChuyen() {
        return (List<Chuyen>) this.chuyenRepository.findAllByStatusEqualsTrue();
    }

    @Override
    public List<Chuyen> findChuyenLimit() {
        return this.chuyenRepository.findChuyenLimit();
    }
}
