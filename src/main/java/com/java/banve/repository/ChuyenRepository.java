package com.java.banve.repository;

import com.java.banve.entity.Chuyen;
import com.java.banve.entity.Loai;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenRepository extends CrudRepository<Chuyen, Integer> {
    @Query(nativeQuery = true, value = "select * from vexe.chuyen order by id desc limit 2")
    List<Chuyen> findChuyenLimit();
    @Query(nativeQuery = true, value = "select * from vexe.chuyen where status = 1")
    List<Chuyen> findAllByStatusEqualsTrue();
}
