package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "monthly_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MonthlyReportEntity {

    @Id
    @Column(name = "id")
    private Long monthlyReportId;

    @Column(name = "date_of_report")
    private LocalDate dateOfReport;

    @Column(name = "number_of_eggs_per_person")
    private double numberOfEggsPerPerson;

    @Column(name = "liters_of_milk_per_person")
    private double litersOfMilkPerPerson;

    @Column(name = "number_of_workers_per_fox")
    private double numberOfWorkersPerFox;

    @Column(name = "kg_of_cheese_per_person")
    private double kgOfCheesePerPerson;

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "monthlyReport")
    private List<WeeklyMonthlyReportEntity> weeklyMonthlyReports = new ArrayList<>();
}