package org.sawaklaudia.domain.compositekeys;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HenhouseWeeklyReportId implements Serializable {

    private Long henhouseReportId;
    private Long weeklyReportId;
}
