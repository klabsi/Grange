package org.sawaklaudia.main;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class Henhouse {

    public static void main(String[] args) {
        SpringApplication.run(Henhouse.class, args);
    }

}
