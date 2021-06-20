package com.java.banve.repository;

import com.java.banve.entity.Seat;
import com.java.banve.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {
    List<Seat> findAllByChuyen_Id(Integer id);

    @Query(nativeQuery = true, value = "select * from vexe.seat inner join vexe.chuyen on vexe.chuyen.id = ?1 and vexe.seat.chuyen_id = vexe.chuyen.id where vexe.seat.status = 1")
    List<Seat> findAllSeatEnableByChuyenID(Integer id);

}
