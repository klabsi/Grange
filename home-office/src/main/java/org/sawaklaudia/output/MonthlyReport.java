package org.sawaklaudia.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
public class MonthlyReport {

    private int numberOfEggsProduction;
    private double literOfMilkProduction;
    private int numberOfFoxAttacks;
    private double kgOfCheeseProduction;
}
