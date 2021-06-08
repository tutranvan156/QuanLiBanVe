package com.java.banve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DoAnJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoAnJavaApplication.class, args);
        index();
    }

    private static void index() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd /c start chrome.exe http://localhost:8080/");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
