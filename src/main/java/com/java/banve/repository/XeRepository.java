package com.java.banve.repository;

import com.java.banve.entity.Ve;
import com.java.banve.entity.Xe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XeRepository extends CrudRepository<Xe, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM vexe.xe s order by id desc limit 2")
    List<Xe> findXeLimit();
}
