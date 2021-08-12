package com.java.banve.repository;

import com.java.banve.entity.Ve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VeRepository extends CrudRepository<Ve, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM vexe.ve s order by id desc limit 2")
    List<Ve> findVeLimit();

    @Query(nativeQuery = true, value = "SELECT * FROM vexe.ve where status = 0 and xoa = 1")
    List<Ve> findAllVeChuaDuyet();

    @Query(nativeQuery = true, value = "SELECT * FROM vexe.ve where user_id = ?1 and xoa = 1")
    List<Ve> findAllVeByUserId(Integer user_id);

    @Query(nativeQuery = true, value = "select * from vexe.ve \n" +
            "inner join vexe.seat\n" +
            "\ton vexe.ve.seat_id = vexe.seat.id\n" +
            "inner join vexe.chuyen\n" +
            "\ton vexe.chuyen.id = vexe.seat.chuyen_id where vexe.ve.user_id = ?1 and vexe.ve.xoa = 1 and vexe.chuyen.ngay between ?2 and ?3")
    List<Ve> findAllVeFromDateToDate(Integer user_id, String start, String end);
}
