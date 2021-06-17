package com.java.banve.repository;

import com.java.banve.entity.User;
import com.java.banve.entity.Xe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findByUsername(String username);
    @Query(nativeQuery = true, value = "select * from vexe.user where status = 1")
    List<User> findAllByStatusEqualsTrue();

    @Query(nativeQuery = true, value = "select * from vexe.user inner join vexe.user_role on vexe.user.id = vexe.user_role.user_id where vexe.user_role.role_id = 2 and vexe.user.status = 1")
    List<User> findAllEmployee();
}
