package com.java.banve.service.impl;

import com.java.banve.entity.User;
import com.java.banve.repository.UserRepository;
import com.java.banve.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserRepository userRepository;


    @Override
    public void sendEmail(String destination, String password) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(destination);
        simpleMailMessage.setSubject("Lay lai mat khau");
        simpleMailMessage.setText(password);
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    @Override

    public Boolean checkUserExit(String email) {
        if (this.userRepository.findUserByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void thayMatKhau(String email, String password) {
        User user = new User();
        user = this.userRepository.findUserByEmail(email);
        user.setPassword(password);
        this.userRepository.save(user);
    }
}
