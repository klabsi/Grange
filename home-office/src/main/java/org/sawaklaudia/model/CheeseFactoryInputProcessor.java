package org.sawaklaudia.model;

import org.sawaklaudia.input.CheeseFactoryInput;

public class CheeseFactoryInputProcessor {

    public double calculateKgOfCheesePerMonth(CheeseFactoryInput cheeseFactoryInput1, CheeseFactoryInput cheeseFactoryInput2, CheeseFactoryInput cheeseFactoryInput3,
                                              CheeseFactoryInput cheeseFactoryInput4) {
        return cheeseFactoryInput1.getKgOfCheesePerWeek() + cheeseFactoryInput2.getKgOfCheesePerWeek()
                + cheeseFactoryInput3.getKgOfCheesePerWeek() + cheeseFactoryInput4.getKgOfCheesePerWeek();
    }

    public double processKgOfCheesePerPerson(CheeseFactoryInput cheeseFactoryInput) {
        return cheeseFactoryInput.getKgOfCheesePerWeek() / cheeseFactoryInput.getNumberOfWorkersPerWeek();
    }
}
