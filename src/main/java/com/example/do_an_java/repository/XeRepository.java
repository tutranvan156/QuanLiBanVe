package com.example.do_an_java.repository;

import com.example.do_an_java.entity.Xe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends CrudRepository<Xe, Integer> {
}
