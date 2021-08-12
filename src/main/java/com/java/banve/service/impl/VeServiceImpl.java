package com.java.banve.service.impl;

import com.java.banve.entity.Chuyen;
import com.java.banve.entity.Seat;
import com.java.banve.entity.User;
import com.java.banve.entity.Ve;
import com.java.banve.model.Search;
import com.java.banve.model.SearchListVeDTO;
import com.java.banve.model.UserTicketDTO;
import com.java.banve.model.VeDTO;
import com.java.banve.repository.SeatRepository;
import com.java.banve.repository.UserRepository;
import com.java.banve.repository.VeRepository;
import com.java.banve.service.ChuyenService;
import com.java.banve.service.SeatService;
import com.java.banve.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VeServiceImpl implements VeService {
    @Autowired
    SeatService seatService;
    @Autowired
    VeRepository veRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChuyenService chuyenService;
    @Autowired
    SeatRepository seatRepository;


    @Override
    public void xoaVe(Integer id) {
        Ve ve = veRepository.findById(id).get();
        this.veRepository.delete(ve);
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
        veDTO.setGia(String.valueOf(ve.getSeat().getChuyen().getXe().getLoai().getGia()));
        veDTO.setNgay(new SimpleDateFormat("yyyy-MM-dd").format(ve.getSeat().getChuyen().getDate()));
        veDTO.setDiachi(ve.getUser().getDiachi());
        veDTO.setSdt(ve.getUser().getSdt());
        veDTO.setTenTuyen(ve.getSeat().getChuyen().getTuyen().getTentuyen());
        veDTO.setTenXe(ve.getSeat().getChuyen().getXe().getTen());
//        veDTO.setVeID(ve.getId());
        return veDTO;
    }
    @Override
    public List<VeDTO> tatCaVeChuaDuyet() {
        List<Ve> list =  this.veRepository.findAllVeChuaDuyet();
        List<VeDTO> temp = new ArrayList<>();
        Ve ve = new Ve();
        for (int i = 0; i < list.size(); i++) {
            VeDTO veDTO = new VeDTO();
            ve = list.get(i);
            veDTO.setId(i + 1);
            veDTO.setVeID(ve.getId());
            veDTO.setFullName(ve.getUser().getHo() + " " + ve.getUser().getTen());
            veDTO.setDiemDen(ve.getDiemDen());
            veDTO.setDiemDi(ve.getDiemDi());
            veDTO.setMaGhe(ve.getSeat().getCode());
            veDTO.setGia(String.valueOf(ve.getSeat().getChuyen().getXe().getLoai().getGia()));
            veDTO.setNgay(new SimpleDateFormat("yyyy-MM-dd").format(ve.getSeat().getChuyen().getDate()));
            veDTO.setTenXe(ve.getSeat().getChuyen().getXe().getTen());
            veDTO.setGio(new SimpleDateFormat("hh:mm").format(ve.getSeat().getChuyen().getTuyen().getGio()));
            temp.add(veDTO);
        }
        return temp;
    }

    @Override
    public void xacNhanVe(Integer id) {
        Ve ve = timVe(id);
        ve.setStatus(true);
        this.veRepository.save(ve);
    }

    @Override
    public List<Ve> findAllVeByUserID(Integer id) {
        return this.veRepository.findAllVeByUserId(id);
    }

    @Override
    public List<VeDTO> findAllVeByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        List<Ve> list = this.veRepository.findAllVeByUserId(user.getId());
        Ve temp = new Ve();
        List<VeDTO> veDTOList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            VeDTO veDTO = new VeDTO();
            veDTO.setId(i + 1);
            veDTO.setFullName(temp.getUser().getHo() + " " + temp.getUser().getTen());
            veDTO.setTenTuyen(temp.getSeat().getChuyen().getTuyen().getTentuyen());
            veDTO.setNgay(new SimpleDateFormat("yyyy-MM-dd").format(temp.getSeat().getChuyen().getDate()));
            veDTO.setGio(new SimpleDateFormat("hh:mm").format(temp.getSeat().getChuyen().getTuyen().getGio()));
            veDTO.setGia(String.valueOf(temp.getSeat().getChuyen().getXe().getLoai().getGia()));
            veDTO.setVeID(temp.getId());
            veDTOList.add(veDTO);
        }
        return veDTOList;
    }

    @Override
    public Boolean checkHopLe(Integer chuyen_id, Integer seat_id) {
        Chuyen chuyen = this.chuyenService.timChuyen(chuyen_id);
        List<Seat> seats = (List) chuyen.getSeats();
        return seats.get(seat_id).getStatus();
    }


    @Override
    public void luuVe(UserTicketDTO userTicketDTO) {
        Ve ve = new Ve();
        String[] temp = userTicketDTO.getTenTuyen().split("-");
        ve.setDiemDi(temp[0].trim());
        ve.setDiemDen(temp[1].trim());
        ve.setStatus(false);
        ve.setUser(this.userRepository.findByUsername(userTicketDTO.getUsername()));
        ve.setSeat(this.seatService.findSeatById(userTicketDTO.getSeatCode()));
        ve.getSeat().setStatus(false);
        ve.setXoa(true);
        this.veRepository.save(ve);
    }

    @Override
    public List<VeDTO> findAllVeFromDateToDate(Search search, String username) throws ParseException {
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(search.getStart());
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(search.getEnd());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String strStart = dateFormat.format(start);
        String strEnd = dateFormat.format(end);

        User user = this.userRepository.findByUsername(username);
        List<Ve> list = this.veRepository.findAllVeFromDateToDate(user.getId(), strStart, strEnd);
        Ve temp = new Ve();
        List<VeDTO> veDTOList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            VeDTO veDTO = new VeDTO();
            veDTO.setId(i + 1);
            veDTO.setFullName(temp.getUser().getHo() + " " + temp.getUser().getTen());
            veDTO.setTenTuyen(temp.getSeat().getChuyen().getTuyen().getTentuyen());
            veDTO.setNgay(new SimpleDateFormat("yyyy-MM-dd").format(temp.getSeat().getChuyen().getDate()));
            veDTO.setGio(new SimpleDateFormat("hh:mm").format(temp.getSeat().getChuyen().getTuyen().getGio()));
            veDTO.setGia(String.valueOf(temp.getSeat().getChuyen().getXe().getLoai().getGia()));
            veDTO.setVeID(temp.getId());
            veDTOList.add(veDTO);
        }
        return veDTOList;
    }
}
