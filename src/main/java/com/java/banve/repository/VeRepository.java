package com.java.banve.repository;

import com.java.banve.entity.Tuyen;
import com.java.banve.entity.Ve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeRepository extends CrudRepository<Ve, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM vexe.ve s order by id desc limit 2")
    List<Ve> findVeLimit();
    @Query(nativeQuery = true, value = "SELECT * FROM vexe.ve where status = 1")
    List<Ve> findAllVeChuaDuyet();
}
