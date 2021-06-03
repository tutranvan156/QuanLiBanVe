package com.java.banve.repository;

import com.java.banve.entity.Chuyen;
import com.java.banve.entity.Loai;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiRepository extends CrudRepository<Loai, Integer> {
    @Query(nativeQuery = true, value = "select * from vexe.loai order by id desc limit 2")
    List<Loai> findLoaiLimit();
}
