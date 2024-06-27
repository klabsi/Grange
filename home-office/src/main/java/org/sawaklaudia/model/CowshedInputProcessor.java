package org.sawaklaudia.model;

import org.sawaklaudia.input.CowshedInput;

public class CowshedInputProcessor {

    public double calculateLitersOfMilkPerMonth(CowshedInput cowshedInput1, CowshedInput cowshedInput2, CowshedInput cowshedInput3,
                                                CowshedInput cowshedInput4) {
        if (cowshedInput1 == null || cowshedInput2 == null || cowshedInput3 == null || cowshedInput4 == null) {
            throw new IllegalArgumentException("Cowshed input cannot be null.");
        }

        return cowshedInput1.getLitersOfMilkPerWeek() + cowshedInput2.getLitersOfMilkPerWeek()
                + cowshedInput3.getLitersOfMilkPerWeek() + cowshedInput4.getLitersOfMilkPerWeek();
    }

    public double processLiterOfMilkPerPerson(CowshedInput cowshedInput) {
        if (cowshedInput == null) throw new IllegalArgumentException("Cowshed input cannot be null.");
        return cowshedInput.getLitersOfMilkPerWeek() / cowshedInput.getNumberOfWorkersPerWeek();
    }
}
