package org.sawaklaudia.model;

import org.sawaklaudia.output.WeeklyReport;

public class WeeklyReportFactory {

    public WeeklyReport process(double numberOfEggsPerPerson, double literOfMilkPerPerson, double numberOfPersonPerFox,
                                double kgOfCheesePerPerson) {
        return WeeklyReport.builder()
                .numberOfEggsPerPerson(numberOfEggsPerPerson)
                .literOfMilkPerPerson(literOfMilkPerPerson)
                .numberOfPersonPerFox(numberOfPersonPerFox)
                .kgOfCheesePerPerson(kgOfCheesePerPerson)
                .build();
    }
}
