package org.sawaklaudia.model;

import org.sawaklaudia.output.WeeklyReport;

public class WeeklyReportFactory {

    public WeeklyReport process(double numberOfEggsPerWorker, double literOfMilkPerWorker, double numberOfWorkerPerFox,
                                double kgOfCheesePerWorker) {
        return WeeklyReport.builder()
                .numberOfEggsPerWorker(numberOfEggsPerWorker)
                .literOfMilkPerWorker(literOfMilkPerWorker)
                .numberOfWorkerPerFox(numberOfWorkerPerFox)
                .kgOfCheesePerWorker(kgOfCheesePerWorker)
                .build();
    }
}
