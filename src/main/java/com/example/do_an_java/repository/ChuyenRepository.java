package com.example.do_an_java.repository;

import com.example.do_an_java.entity.Chuyen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenRepository extends CrudRepository<Chuyen, Integer> {
}
