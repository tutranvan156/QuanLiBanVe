package com.example.do_an_java.repository;

import com.example.do_an_java.entity.KhachHang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<KhachHang, Integer> {

}
