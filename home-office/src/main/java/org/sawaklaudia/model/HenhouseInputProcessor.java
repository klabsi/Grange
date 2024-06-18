package org.sawaklaudia.model;

import org.sawaklaudia.input.HenhouseInput;

public class HenhouseInputProcessor {

    public int calculateNumOfEggsPerMonth(HenhouseInput henhouseInput1, HenhouseInput henhouseInput2, HenhouseInput henhouseInput3, HenhouseInput henhouseInput4) {
        return henhouseInput1.getNumberOfEggsPerWeek() + henhouseInput2.getNumberOfEggsPerWeek()
                + henhouseInput3.getNumberOfEggsPerWeek() + henhouseInput4.getNumberOfEggsPerWeek();
    }

    public double processNumOfEggsPerPerson(HenhouseInput henhouseInput) {
        return (double) henhouseInput.getNumberOfEggsPerWeek() / henhouseInput.getNumberOfWorkersPerWeek();
    }
}
