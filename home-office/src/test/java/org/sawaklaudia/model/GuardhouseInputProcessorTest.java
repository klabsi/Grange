package org.sawaklaudia.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.sawaklaudia.input.GuardhouseInput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GuardhouseInputProcessorTest {

    private GuardhouseInputProcessor guardhouseInputProcessor;
    private GuardhouseInput guardhouseInput1;
    private GuardhouseInput guardhouseInput2;
    private GuardhouseInput guardhouseInput3;
    private GuardhouseInput guardhouseInput4;

    @BeforeAll
    void setUp() {
        guardhouseInputProcessor = new GuardhouseInputProcessor();
        guardhouseInput1 = GuardhouseInput.builder()
                .numberOfFoxAttacks(1)
                .numberOfWorkers(1)
                .build();

        guardhouseInput2 = GuardhouseInput.builder()
                .numberOfFoxAttacks(1)
                .numberOfWorkers(1)
                .build();

        guardhouseInput3 = GuardhouseInput.builder()
                .numberOfFoxAttacks(1)
                .numberOfWorkers(1)
                .build();

        guardhouseInput4 = GuardhouseInput.builder()
                .numberOfFoxAttacks(1)
                .numberOfWorkers(1)
                .build();
    }

    @Test
    void shouldReturnFourWhenSetOneFoxAttacksEveryWeek() {
        //given when
        int actual = guardhouseInputProcessor.calculateNumberOfFoxAttacksPerMonth(guardhouseInput1, guardhouseInput2,
                guardhouseInput3, guardhouseInput4);

        //then
        Assertions.assertEquals(4.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullInput(GuardhouseInput guardhouseInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> guardhouseInputProcessor.calculateNumberOfFoxAttacksPerMonth(guardhouseInput1,
                guardhouseInput2, guardhouseInput3, guardhouseInput4));
    }

    @Test
    void shouldReturnOneWhenProcessNumberOfWorkerPerFox() {
        //given when
        double actual = guardhouseInputProcessor.processNumberOfWorkersPerFox(guardhouseInput1);

        //then
        Assertions.assertEquals(1.0, actual);
    }

    @Test
    void shouldReturnZeroWhenSetZeroFoxAttacks() {
        //given
        GuardhouseInput zeroInput = GuardhouseInput.builder()
                .numberOfFoxAttacks(0)
                .numberOfWorkers(1)
                .build();
        // when
        double actual = guardhouseInputProcessor.processNumberOfWorkersPerFox(zeroInput);

        //then
        Assertions.assertEquals(0.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullAsInput(GuardhouseInput guardhouseInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> guardhouseInputProcessor.processNumberOfWorkersPerFox(guardhouseInput1));
    }
}