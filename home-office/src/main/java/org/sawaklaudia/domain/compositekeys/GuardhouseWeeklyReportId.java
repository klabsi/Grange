package org.sawaklaudia.domain.compositekeys;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GuardhouseWeeklyReportId implements Serializable {

    private Long guardhouseReportId;
    private Long weeklyReportId;
}
