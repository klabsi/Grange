package org.sawaklaudia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeOffice {
    public static void main(String[] args) {
        SpringApplication.run(HomeOffice.class, args);
        System.out.println("biuro domowe");
    }
}