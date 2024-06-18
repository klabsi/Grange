package org.sawaklaudia.model;

import org.sawaklaudia.output.MonthlyReport;

public class MonthlyReportFactory {

    public MonthlyReport process(int numberOfEggsPerMonth, double literOfMilkPPerMonth, int numberOfFoxAttacksPerMonth,
                                 double kgOfCheesePerMonth) {
        return MonthlyReport.builder()
                .numberOfEggsProduction(numberOfEggsPerMonth)
                .literOfMilkProduction(literOfMilkPPerMonth)
                .numberOfFoxAttacks(numberOfFoxAttacksPerMonth)
                .kgOfCheeseProduction(kgOfCheesePerMonth).
                build();
    }
}