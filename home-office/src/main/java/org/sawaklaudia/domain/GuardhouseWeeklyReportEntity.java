package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sawaklaudia.domain.compositekeys.GuardhouseWeeklyReportId;

@Entity
@Table(name = "guardhouse_weekly_report")
@IdClass(GuardhouseWeeklyReportId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GuardhouseWeeklyReportEntity {

    @Id
    @Column(name = "guardhouse_report_id")
    private Long guardHouseReportId;

    @Id
    @Column(name = "weekly_report_id")
    private Long weeklyReportId;
}
