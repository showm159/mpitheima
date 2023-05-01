package com.mpitheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MPApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPApplication.class,args);
        System.out.println(111);
        System.out.println(222);
        System.out.println(333);
    }
}