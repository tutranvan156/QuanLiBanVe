package com.java.banve.repository;

import com.java.banve.entity.Chuyen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenRepository extends CrudRepository<Chuyen, Integer> {
}
