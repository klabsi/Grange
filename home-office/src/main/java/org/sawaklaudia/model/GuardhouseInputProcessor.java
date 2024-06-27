package org.sawaklaudia.model;

import org.sawaklaudia.input.GuardhouseInput;

public class GuardhouseInputProcessor {

    public int calculateNumberOfFoxAttacksPerMonth(GuardhouseInput guardhouseInput1, GuardhouseInput guardhouseInput2, GuardhouseInput guardhouseInput3, GuardhouseInput guardhouseInput4) {
        if (guardhouseInput1 == null || guardhouseInput2 == null || guardhouseInput3 == null || guardhouseInput4 == null) {
            throw new IllegalArgumentException("Guardhouse input cannot be null.");
        }

        return guardhouseInput1.getNumberOfFoxAttacksPerWeek() + guardhouseInput2.getNumberOfFoxAttacksPerWeek()
                + guardhouseInput3.getNumberOfFoxAttacksPerWeek() + guardhouseInput4.getNumberOfFoxAttacksPerWeek();
    }

    public double processNumberOfPersonPerFox(GuardhouseInput guardhouseInput) {
        if (guardhouseInput == null) throw new IllegalArgumentException("Guardhouse input cannot be null.");
        int numberOfFoxAttacksPerWeek = guardhouseInput.getNumberOfFoxAttacksPerWeek();
        if (numberOfFoxAttacksPerWeek == 0) return 0.0;
        return (double) guardhouseInput.getNumberOfWorkersPerWeek() / numberOfFoxAttacksPerWeek;
    }
}
