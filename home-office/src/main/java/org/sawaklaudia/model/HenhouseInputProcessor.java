package org.sawaklaudia.model;

import org.sawaklaudia.input.HenhouseInput;

public class HenhouseInputProcessor {

    public int calculateNumOfEggsPerMonth(HenhouseInput henhouseInput1, HenhouseInput henhouseInput2, HenhouseInput henhouseInput3, HenhouseInput henhouseInput4) {
        if (henhouseInput1 == null || henhouseInput2 == null || henhouseInput3 == null || henhouseInput4 == null) {
            throw new IllegalArgumentException("Henhouse input cannot be null.");
        }

        return henhouseInput1.getNumberOfEggsPerWeek() + henhouseInput2.getNumberOfEggsPerWeek()
                + henhouseInput3.getNumberOfEggsPerWeek() + henhouseInput4.getNumberOfEggsPerWeek();
    }

    public double processNumOfEggsPerPerson(HenhouseInput henhouseInput) {
        if (henhouseInput == null) throw new IllegalArgumentException("Cheese factory input cannot be null.");
        return (double) henhouseInput.getNumberOfEggsPerWeek() / henhouseInput.getNumberOfWorkersPerWeek();
    }
}
