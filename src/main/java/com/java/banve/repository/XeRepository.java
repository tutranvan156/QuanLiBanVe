package com.java.banve.repository;

import com.java.banve.entity.Xe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends CrudRepository<Xe, Integer> {
}
