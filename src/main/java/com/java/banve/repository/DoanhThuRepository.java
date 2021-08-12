package com.java.banve.repository;

import com.java.banve.entity.Ve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoanhThuRepository extends CrudRepository<Ve, Integer> {

    @Query(nativeQuery = true, value = "select count(*) from vexe.ve " +
            "inner join vexe.seat inner join " +
            "vexe.chuyen on vexe.chuyen.id = vexe.seat.chuyen_id and " +
            "vexe.ve.seat_id = vexe.seat.id where vexe.ve.status = 1 and vexe.chuyen.ngay between ?1 and ?2 and diemdi = ?3")
    Integer countAll(String fromDate, String toDate, String location);
}
