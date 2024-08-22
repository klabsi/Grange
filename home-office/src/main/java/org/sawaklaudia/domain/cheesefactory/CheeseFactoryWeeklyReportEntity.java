package org.sawaklaudia.domain.cheesefactory;

import jakarta.persistence.*;
import lombok.*;
import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.domain.compositekeys.CheeseFactoryWeeklyReportId;

@Entity
@Table(name = "cheese_factory_weekly_report")
@IdClass(CheeseFactoryWeeklyReportId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CheeseFactoryWeeklyReportEntity {

    @Id
    @Column(name = "cheese_factory_report_id")
    private Long cheeseFactoryReportId;

    @Id
    @Column(name = "weekly_report_id")
    private Long weeklyReportId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weekly_report_id")
    private WeeklyReportEntity weeklyReport;

    @OneToOne
    @JoinColumn(name = "cheese_factory_report_id")
    private CheeseFactoryReportEntity cheeseFactoryReport;
}
