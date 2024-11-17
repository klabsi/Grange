package org.sawaklaudia.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
public class WeeklyReport {

    private double numberOfEggsPerWorker;
    private double literOfMilkPerWorker;
    private double numberOfWorkerPerFox;
    private double kgOfCheesePerWorker;
}
