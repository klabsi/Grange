package org.sawaklaudia.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
        basePackages = {
                "org.bitbucket.tek.nik.simplifiedswagger",
                "org.sawaklaudia"
        }
        )
@SpringBootApplication
public class Guardhouse {

    public static void main(String[] args) {
        SpringApplication.run(Guardhouse.class, args);
    }

}
