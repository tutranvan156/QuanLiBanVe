package com.example.do_an_java.repository;

import com.example.do_an_java.entity.Loai;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiRepository extends CrudRepository<Loai, Integer> {
}
