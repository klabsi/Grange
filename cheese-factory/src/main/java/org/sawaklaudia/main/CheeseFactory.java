package org.sawaklaudia.main;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class CheeseFactory {

    public static void main(String[] args) {
        SpringApplication.run(CheeseFactory.class, args);
    }

}
