package com.java.banve.service.impl;

import com.java.banve.entity.Seat;
import com.java.banve.repository.SeatRepository;
import com.java.banve.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;
    @Override
    public List<Seat> findAllSeatByChuyenID(Integer id) {
        return this.seatRepository.findAllByChuyen_Id(id);
    }
}
