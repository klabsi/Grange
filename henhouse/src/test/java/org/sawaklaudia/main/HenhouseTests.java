package org.sawaklaudia.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class HenhouseTests {

    @Test
    void contextLoads() {
    }

}
