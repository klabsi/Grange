package org.sawaklaudia.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.sawaklaudia.input.CheeseFactoryInput;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CheeseFactoryInputProcessorTest {

    private CheeseFactoryInputProcessor cheeseFactoryInputProcessor;
    private CheeseFactoryInput cheeseFactoryInput1;
    private CheeseFactoryInput cheeseFactoryInput2;
    private CheeseFactoryInput cheeseFactoryInput3;
    private CheeseFactoryInput cheeseFactoryInput4;

    @BeforeAll
    void setUp() {
        cheeseFactoryInputProcessor = new CheeseFactoryInputProcessor();
        cheeseFactoryInput1 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();
        cheeseFactoryInput2 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();
        cheeseFactoryInput3 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();
        cheeseFactoryInput4 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(1)
                .numberOfWorkersPerWeek(1)
                .build();
    }

    @Test
    void shouldReturnFourWhenSetOneKgOfCheeseEveryWeek() {
        //given when
        double actual = cheeseFactoryInputProcessor.calculateKgOfCheesePerMonth(cheeseFactoryInput1, cheeseFactoryInput2,
                cheeseFactoryInput3, cheeseFactoryInput4);
        //then
        Assertions.assertEquals(4.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrownExceptionWhenProcessNullInput(CheeseFactoryInput cheeseFactoryInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cheeseFactoryInputProcessor.calculateKgOfCheesePerMonth(cheeseFactoryInput1, cheeseFactoryInput2,
                cheeseFactoryInput3, cheeseFactoryInput4));
    }

    @Test
    void shouldReturnOneWhenCalculateKgOfCheesePerPerson() {
        //given when
        double actual = cheeseFactoryInputProcessor.processKgOfCheesePerPerson(cheeseFactoryInput1);
        //then
        Assertions.assertEquals(1.0, actual);
    }

    @ParameterizedTest
    @NullSource
    void shouldThrownExceptionWhenCalculateKgOfCheesePerPersonWithNullInput(CheeseFactoryInput cheeseFactoryInput1) {
        //given when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> cheeseFactoryInputProcessor.processKgOfCheesePerPerson(cheeseFactoryInput1));
    }
}