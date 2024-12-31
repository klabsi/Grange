package org.sawaklaudia.main;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class Cowshed {

    public static void main(String[] args) {
        SpringApplication.run(Cowshed.class, args);
    }

}
