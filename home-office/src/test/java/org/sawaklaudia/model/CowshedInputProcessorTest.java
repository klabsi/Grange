package org.sawaklaudia.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.sawaklaudia.input.CowshedInput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CowshedInputProcessorTest {

    private CowshedInputProcessor cowshedInputProcessor;
    private CowshedInput cowshedInput1;
    private CowshedInput cowshedInput2;
    private CowshedInput cowshedInput3;
    private CowshedInput cowshedInput4;

    @BeforeAll
    void setUp() {
        cowshedInputProcessor = new CowshedInputProcessor();
        cowshedInput1 = CowshedInput.builder()
                .litersOfMilkPerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();

        cowshedInput2 = CowshedInput.builder()
                .litersOfMilkPerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();

        cowshedInput3 = CowshedInput.builder()
                .litersOfMilkPerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();

        cowshedInput4 = CowshedInput.builder()
                .litersOfMilkPerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();
    }

    @Test
    void shouldReturnFourWhenSetOneLiterOfMilkEveryWeek() {
        //given when
        double actual = cowshedInputProcessor.calculateLitersOfMilkPerMonth(cowshedInput1, cowshedInput2,
                cowshedInput3, cowshedInput4);

        //then
        Assertions.assertEquals(4.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullInput(CowshedInput cowshedInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cowshedInputProcessor.calculateLitersOfMilkPerMonth(cowshedInput1,
                cowshedInput2, cowshedInput3, cowshedInput4));
    }

    @Test
    void shouldReturnOneWhenCalculateLitersOfMilkPerPerson() {
        //given when
        double actual = cowshedInputProcessor.processLiterOfMilkPerPerson(cowshedInput1);

        //then
        Assertions.assertEquals(1.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowsExceptionWhenProcessNullAsInput(CowshedInput cowshedInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cowshedInputProcessor.processLiterOfMilkPerPerson(cowshedInput1));
    }
}