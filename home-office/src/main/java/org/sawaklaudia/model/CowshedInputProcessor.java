package org.sawaklaudia.model;

import org.sawaklaudia.input.CowshedInput;

public class CowshedInputProcessor {

    public double calculateLitersOfMilkPerMonth(CowshedInput cowshedInput1, CowshedInput cowshedInput2, CowshedInput cowshedInput3,
                                                CowshedInput cowshedInput4) {
        return cowshedInput1.getLitersOfMilkPerWeek() + cowshedInput2.getLitersOfMilkPerWeek()
                + cowshedInput3.getLitersOfMilkPerWeek() + cowshedInput4.getLitersOfMilkPerWeek();
    }

    public double processLiterOfMilkPerPerson(CowshedInput cowshedInput) {
        return cowshedInput.getLitersOfMilkPerWeek() / cowshedInput.getNumberOfWorkersPerWeek();
    }
}
