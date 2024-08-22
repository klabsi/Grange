package org.sawaklaudia.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class CheeseFactoryInput {

    private double kgOfCheesePerWeek;
    private int numberOfWorkersPerWeek;
    private LocalDate dateOfReport;
}
