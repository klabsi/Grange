package org.sawaklaudia.model;

import org.sawaklaudia.input.CheeseFactoryInput;
import java.util.List;

public class CheeseFactoryInputProcessor {

    public double calculateKgOfCheesePerMonth(CheeseFactoryInput cheeseFactoryInput1, CheeseFactoryInput cheeseFactoryInput2, CheeseFactoryInput cheeseFactoryInput3,
                                              CheeseFactoryInput cheeseFactoryInput4) {
        if (cheeseFactoryInput1 == null || cheeseFactoryInput2 == null || cheeseFactoryInput3 == null || cheeseFactoryInput4 == null) {
            throw new IllegalArgumentException("Cheese factory input cannot be null.");
        }

        return cheeseFactoryInput1.getKgOfCheese() + cheeseFactoryInput2.getKgOfCheese()
                + cheeseFactoryInput3.getKgOfCheese() + cheeseFactoryInput4.getKgOfCheese();
    }

    public double processKgOfCheesePerWorkerPerWeek(List<CheeseFactoryInput> cheeseFactoryInputsFromAWeek) {
        if (cheeseFactoryInputsFromAWeek == null) throw new IllegalArgumentException("Cheese factory input cannot be null.");

        double totalKgOfCheese = 0;
        int totalNumberOfWorkers = 0;
        for (CheeseFactoryInput input : cheeseFactoryInputsFromAWeek) {
            totalKgOfCheese += input.getKgOfCheese();
            totalNumberOfWorkers += input.getNumberOfWorkers();
        }
        return totalKgOfCheese/totalNumberOfWorkers;
    }
}
