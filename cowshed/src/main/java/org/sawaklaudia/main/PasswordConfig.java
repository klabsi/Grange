package org.sawaklaudia.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    private static final int ENCODER_STRENGTH = 10;

    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder(ENCODER_STRENGTH);
    }
}
