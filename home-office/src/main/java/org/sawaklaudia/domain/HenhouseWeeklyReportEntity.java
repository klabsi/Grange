package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sawaklaudia.domain.compositekeys.HenhouseWeeklyReportId;

@Entity
@Table(name = "henhouse_weekly_report")
@IdClass(HenhouseWeeklyReportId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HenhouseWeeklyReportEntity {

    @Id
    @Column(name = "henhouse_report_id")
    private Long henhouseReportId;

    @Id
    @Column(name = "weekly_report_id")
    private Long weeklyReportId;
}
