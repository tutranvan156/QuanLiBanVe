package com.java.banve.repository;

import com.java.banve.entity.Tuyen;
import com.java.banve.entity.Xe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuyenRepository extends CrudRepository<Tuyen, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM vexe.tuyen s order by id desc limit 2")
    List<Tuyen> findTuyenLimit();
    @Query(nativeQuery = true, value = "select * from vexe.tuyen where status = 1")
    List<Tuyen> findAllByStatusEqualsTrue();

}
