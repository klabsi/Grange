package org.sawaklaudia.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootTest
public class HomeOfficeTests {

    @Test
    void contextLoads() {
    }
}
