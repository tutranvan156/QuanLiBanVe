package com.java.banve;

import com.java.banve.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoAnJavaApplication{

    public static void main(String[] args) {
        SpringApplication.run(DoAnJavaApplication.class, args);
    }
}
