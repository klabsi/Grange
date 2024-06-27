package org.sawaklaudia.model;

import org.sawaklaudia.input.CheeseFactoryInput;

public class CheeseFactoryInputProcessor {

    public double calculateKgOfCheesePerMonth(CheeseFactoryInput cheeseFactoryInput1, CheeseFactoryInput cheeseFactoryInput2, CheeseFactoryInput cheeseFactoryInput3,
                                              CheeseFactoryInput cheeseFactoryInput4) {
        if (cheeseFactoryInput1 == null || cheeseFactoryInput2 == null || cheeseFactoryInput3 == null || cheeseFactoryInput4 == null) {
            throw new IllegalArgumentException("Cheese factory input cannot be null.");
        }

        return cheeseFactoryInput1.getKgOfCheesePerWeek() + cheeseFactoryInput2.getKgOfCheesePerWeek()
                + cheeseFactoryInput3.getKgOfCheesePerWeek() + cheeseFactoryInput4.getKgOfCheesePerWeek();
    }

    public double processKgOfCheesePerPerson(CheeseFactoryInput cheeseFactoryInput) {
        if (cheeseFactoryInput == null) throw new IllegalArgumentException("Cheese factory input cannot be null.");
        return cheeseFactoryInput.getKgOfCheesePerWeek() / cheeseFactoryInput.getNumberOfWorkersPerWeek();
    }
}
