package com.java.banve.repository;

import com.java.banve.entity.Tuyen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuyenRepository extends CrudRepository<Tuyen, Integer> {

}
