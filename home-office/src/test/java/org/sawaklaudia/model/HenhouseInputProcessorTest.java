package org.sawaklaudia.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.sawaklaudia.input.HenhouseInput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HenhouseInputProcessorTest {

    private HenhouseInputProcessor henhouseInputProcessor;
    private HenhouseInput henhouseInput1;
    private HenhouseInput henhouseInput2;
    private HenhouseInput henhouseInput3;
    private HenhouseInput henhouseInput4;

    @BeforeAll
    void setUp() {
        henhouseInputProcessor = new HenhouseInputProcessor();
        henhouseInput1 = HenhouseInput.builder()
                .numberOfEggs(1)
                .numberOfWorkers(1)
                .build();

        henhouseInput2 = HenhouseInput.builder()
                .numberOfEggs(1)
                .numberOfWorkers(1)
                .build();

        henhouseInput3 = HenhouseInput.builder()
                .numberOfEggs(1)
                .numberOfWorkers(1)
                .build();

        henhouseInput4 = HenhouseInput.builder()
                .numberOfEggs(1)
                .numberOfWorkers(1)
                .build();
    }

    @Test
    void shouldReturnFourWhenSetOneEggEveryWeek() {
        //given when
        int actual = henhouseInputProcessor.calculateNumOfEggsPerMonth(henhouseInput1, henhouseInput1,
                henhouseInput3, henhouseInput4);

        //then
        Assertions.assertEquals(4.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullInput(HenhouseInput henhouseInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> henhouseInputProcessor.calculateNumOfEggsPerMonth(henhouseInput1,
                henhouseInput2, henhouseInput3, henhouseInput4));
    }

    @Test
    void shouldReturnOneWhenProcessNumberOfEggsPerWorker() {
        //given when
        double actual = henhouseInputProcessor.processNumOfEggsPerWorker(henhouseInput1);

        //then
        Assertions.assertEquals(1.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullAsInput(HenhouseInput henhouseInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> henhouseInputProcessor.processNumOfEggsPerWorker(henhouseInput1));
    }
}