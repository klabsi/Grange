package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sawaklaudia.domain.compositekeys.CowshedWeeklyReportId;

@Entity
@Table(name = "cowshed_weekly_report")
@IdClass(CowshedWeeklyReportId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CowshedWeeklyReportEntity {

    @Id
    @Column(name = "cowshed_report_id")
    private Long cowshedReportId;

    @Id
    @Column(name = "weekly_report_id")
    private Long weeklyReportId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "weekly_report_fk_id")
    private WeeklyReportEntity weeklyReport;

    @OneToOne
    @JoinColumn(name = "cowshed_report_fk_id")
    private CowshedReportEntity cowshedReport;
}
