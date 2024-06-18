package org.sawaklaudia.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
public class WeeklyReport {

    private double numberOfEggsPerPerson;
    private double literOfMilkPerPerson;
    private double numberOfPersonPerFox;
    private double kgOfCheesePerPerson;
}
