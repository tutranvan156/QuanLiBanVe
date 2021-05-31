package com.java.banve.service;

public interface MailService {
    public void sendEmail(String destination, String password);
    public String generateRandomPassword(int len);
    Boolean checkUserExit(String email);
    void thayMatKhau(String email, String password);
}
