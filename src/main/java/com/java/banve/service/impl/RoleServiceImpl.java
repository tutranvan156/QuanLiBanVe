package com.java.banve.service.impl;

import com.java.banve.entity.Role;
import com.java.banve.repository.RoleRepository;
import com.java.banve.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void addDefaultRole() {
        Role role = new Role(1, "ADMIN");
        Role role1 = new Role(2, "EMPLOYEE");
        Role role2 = new Role(3, "USER");
        this.roleRepository.save(role);
        this.roleRepository.save(role1);
        this.roleRepository.save(role2);
    }
}
