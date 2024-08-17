package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sawaklaudia.domain.compositekeys.WeeklyMonthlyReportId;

@Entity
@Table(name = "weekly_monthly_report")
@IdClass(WeeklyMonthlyReportId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WeeklyMonthlyReportEntity {

    @Id
    @Column(name = "weekly_report_id")
    private Long weeklyReportId;

    @Id
    @Column(name = "monthly_report_id")
    private Long monthlyReportId;
}
