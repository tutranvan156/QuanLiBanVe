package com.java.banve.service;

import com.java.banve.entity.Ve;
import com.java.banve.model.Search;
import com.java.banve.model.SearchListVeDTO;
import com.java.banve.model.UserTicketDTO;
import com.java.banve.model.VeDTO;

import java.text.ParseException;
import java.util.List;

public interface VeService {
    Ve timVe(Integer id);
    void xoaVe(Integer id);
    List<Ve> tatCaVe();
    VeDTO timVeDTO(Integer id);
    List<VeDTO> tatCaVeChuaDuyet();
    void xacNhanVe(Integer id);
    List<Ve> findAllVeByUserID(Integer id);
    List<VeDTO> findAllVeByUsername(String username);
    Boolean checkHopLe(Integer chuyen_id, Integer seat_id);
    void luuVe(UserTicketDTO userTicketDTO);
    List<VeDTO> findAllVeFromDateToDate(Search search, String username) throws ParseException;
}
