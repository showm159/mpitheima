package com.mpitheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MPApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPApplication.class,args);
        System.out.println(999);
        System.out.println(666);
    }
}
