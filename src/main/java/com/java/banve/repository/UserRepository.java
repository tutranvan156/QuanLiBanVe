package com.java.banve.repository;

import com.java.banve.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findByUsername(String username);

}
