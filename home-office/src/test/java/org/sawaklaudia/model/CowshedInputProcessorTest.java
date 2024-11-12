package org.sawaklaudia.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.sawaklaudia.input.CowshedInput;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CowshedInputProcessorTest {

    private CowshedInputProcessor cowshedInputProcessor;
    private CowshedInput cowshedInput1;
    private CowshedInput cowshedInput2;
    private CowshedInput cowshedInput3;
    private CowshedInput cowshedInput4;
    private List<CowshedInput> cowshedInputsFromAWeek;

    @BeforeAll
    void setUp() {
        cowshedInputProcessor = new CowshedInputProcessor();
        cowshedInput1 = CowshedInput.builder()
                .litersOfMilk(1)
                .numberOfWorkers(1)
                .build();

        cowshedInput2 = CowshedInput.builder()
                .litersOfMilk(1)
                .numberOfWorkers(1)
                .build();

        cowshedInput3 = CowshedInput.builder()
                .litersOfMilk(1)
                .numberOfWorkers(1)
                .build();

        cowshedInput4 = CowshedInput.builder()
                .litersOfMilk(1)
                .numberOfWorkers(1)
                .build();

        cowshedInputsFromAWeek = List.of(cowshedInput1, cowshedInput2, cowshedInput3, cowshedInput4);
    }

    @Test
    void shouldReturnFourWhenSetOneLiterOfMilkEveryWeek() {
        //given when
        double actual = cowshedInputProcessor.calcTotalLitersOfMilkPerMonth(cowshedInput1, cowshedInput2,
                cowshedInput3, cowshedInput4);

        //then
        Assertions.assertEquals(4.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullInput(CowshedInput cowshedInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cowshedInputProcessor.calcTotalLitersOfMilkPerMonth(cowshedInput1,
                cowshedInput2, cowshedInput3, cowshedInput4));
    }

    @Test
    void shouldReturnOneWhenCalculateLitersOfMilkPerWorker() {
        //given when
        double actual = cowshedInputProcessor.calcLitersOfMilkPerWorkerPerWeek(cowshedInputsFromAWeek);

        //then
        Assertions.assertEquals(1.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullAsInput(List<CowshedInput> cowshedInputsFromAWeek) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cowshedInputProcessor.calcLitersOfMilkPerWorkerPerWeek(cowshedInputsFromAWeek));
    }
}