package com.java.banve.repository;

import com.java.banve.entity.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {
    List<Seat> findAllByChuyen_Id(Integer id);

}
