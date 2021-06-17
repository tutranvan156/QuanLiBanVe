package com.java.banve.service;

import com.java.banve.model.UserDTO;
import com.java.banve.model.UserInforDTO;

import java.util.List;

public interface AdminService {
    void themEmployee(UserDTO userDTO);
    void xoaEmployee(Integer id);
    List<UserInforDTO> findAllEmployee();
}
