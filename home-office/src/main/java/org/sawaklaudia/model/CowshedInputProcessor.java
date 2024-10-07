package org.sawaklaudia.model;

import org.sawaklaudia.input.CowshedInput;

import java.util.List;

public class CowshedInputProcessor {

    public double calcTotalLitersOfMilkPerMonth(CowshedInput cowshedInput1, CowshedInput cowshedInput2, CowshedInput cowshedInput3,
                                                CowshedInput cowshedInput4) {
        if (cowshedInput1 == null || cowshedInput2 == null || cowshedInput3 == null || cowshedInput4 == null) {
            throw new IllegalArgumentException("Cowshed input cannot be null.");
        }

        return cowshedInput1.getLitersOfMilkPerWeek() + cowshedInput2.getLitersOfMilkPerWeek()
                + cowshedInput3.getLitersOfMilkPerWeek() + cowshedInput4.getLitersOfMilkPerWeek();
    }

    public double calcLitersOfMilkPerWorkerPerWeek(List<CowshedInput> cowshedInputsFromAWeek) {
        if (cowshedInputsFromAWeek == null) throw new IllegalArgumentException("Cowshed inputs list cannot be null.");

        double totalLitersOfMilk = 0;
        int totalNumberOfWorkers = 0;
        for (CowshedInput input : cowshedInputsFromAWeek) {
            totalLitersOfMilk += input.getLitersOfMilkPerWeek();
            totalNumberOfWorkers += input.getNumberOfWorkersPerWeek();
        }
        return totalLitersOfMilk/totalNumberOfWorkers;
    }
}
