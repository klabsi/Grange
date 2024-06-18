package org.sawaklaudia.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Builder
@Getter
public class GuardhouseInput {

    private int numberOfFoxAttacksPerWeek;
    private int numberOfWorkersPerWeek;
    private Instant dateOfReport;
}
