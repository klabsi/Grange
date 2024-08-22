package org.sawaklaudia.domain.guardhouse;

import jakarta.persistence.*;
import lombok.*;
import org.sawaklaudia.domain.WeeklyReportEntity;
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
    private Long guardhouseReportId;

    @Id
    @Column(name = "weekly_report_id")
    private Long weeklyReportId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weekly_report_id")
    private WeeklyReportEntity weeklyReport;

    @OneToOne
    @JoinColumn(name = "guardhouse_report_id")
    private GuardhouseReportEntity guardhouseReport;

    @Override
    public String toString() {
        return "GuardhouseWeeklyReportEntity{" +
                "guardhouseReportId=" + guardhouseReportId +
                ", weeklyReportId=" + weeklyReportId +
                '}';
    }
}
