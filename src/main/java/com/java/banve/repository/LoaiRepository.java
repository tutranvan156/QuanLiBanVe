package com.java.banve.repository;

import com.java.banve.entity.Loai;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiRepository extends CrudRepository<Loai, Integer> {
}
