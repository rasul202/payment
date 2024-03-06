package com.example.mscurrencies;

import feign.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@EnableFeignClients
public class MsCurrenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCurrenciesApplication.class, args);
    }

}
