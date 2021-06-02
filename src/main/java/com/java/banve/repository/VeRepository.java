package com.java.banve.repository;

import com.java.banve.entity.Ve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeRepository extends CrudRepository<Ve, Integer> {
}
