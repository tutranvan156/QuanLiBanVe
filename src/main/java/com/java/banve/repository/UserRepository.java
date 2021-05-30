package com.java.banve.repository;

import com.java.banve.entity.KhachHang;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<KhachHang, Integer> {
    KhachHang findKhachHangByEmail(String email);

}
