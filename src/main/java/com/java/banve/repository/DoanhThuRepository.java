package com.java.banve.repository;

import com.java.banve.entity.Ve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoanhThuRepository extends CrudRepository<Ve, Integer> {
}
