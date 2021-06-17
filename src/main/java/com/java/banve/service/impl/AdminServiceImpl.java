package com.java.banve.service.impl;

import com.java.banve.entity.Role;
import com.java.banve.entity.User;
import com.java.banve.model.UserDTO;
import com.java.banve.model.UserInforDTO;
import com.java.banve.repository.UserRepository;
import com.java.banve.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void themEmployee(UserDTO userDTO) {
        User user = new User();
        user.setHo(userDTO.getHo());
        user.setTen(userDTO.getTen());
        user.setUsername(userDTO.getUsername());
        user.setSdt(userDTO.getSdt());
        user.setDiachi(userDTO.getDiachi());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        Role role1 = new Role(2, "EMPLOYEE");
        Role role2 = new Role(3, "USER");
        user.setRoles(Set.of(role1, role2));
        user.setStatus(true);
        this.userRepository.save(user);
    }

    @Override
    public void xoaEmployee(Integer id) {
        User user = userRepository.findById(id).get();
        user.setStatus(false);
        this.userRepository.save(user);
    }

    @Override
    public List<UserInforDTO> findAllEmployee() {
        List<User> users = this.userRepository.findAllEmployee();
        List<UserInforDTO> userInforDTOList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
           UserInforDTO userInforDTO = new UserInforDTO();
           userInforDTO.setId(users.get(i).getId());
           userInforDTO.setDiachi(users.get(i).getDiachi());
           userInforDTO.setUsername(users.get(i).getUsername());
           userInforDTO.setFullName(users.get(i).getHo() + " " + users.get(i).getTen()) ;
           userInforDTO.setSdt(users.get(i).getSdt());
           userInforDTOList.add(userInforDTO);
        }
        return userInforDTOList;
    }
}
