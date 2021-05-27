package com.example.do_an_java.repository;

import com.example.do_an_java.entity.Tuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuyenRepository extends CrudRepository<Tuyen, Integer> {

}
