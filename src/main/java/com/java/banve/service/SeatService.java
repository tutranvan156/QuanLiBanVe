package com.java.banve.service;

import com.java.banve.entity.Seat;

import java.util.List;

public interface SeatService {
    public List<Seat> findAllSeatByChuyenID(Integer id);
}
