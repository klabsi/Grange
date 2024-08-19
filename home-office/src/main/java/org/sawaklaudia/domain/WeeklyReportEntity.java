package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "weekly_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WeeklyReportEntity {

    @Id
    @Column(name = "id")
    private Long weeklyReportId;

    @Column(name = "date_of_report")
    private Instant dateOfReport;

    @Column(name = "number_of_eggs_per_person")
    private double numberOfEggsPerPerson;

    @Column(name = "liters_of_milk_per_person")
    private double litersOfMilkPerPerson;

    @Column(name = "number_of_workers_per_fox")
    private double numberOfWorkersPerFox;

    @Column(name = "kg_of_cheese_per_person")
    private double kgOfCheesePerPerson;

    @OneToOne(mappedBy = "weeklyReport")
    private WeeklyMonthlyReportEntity weeklyMonthlyReport;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "weeklyReport")
    private List<CheeseFactoryWeeklyReportEntity> cheeseFactoryWeeklyReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "weeklyReport")
    private List<CowshedWeeklyReportEntity> cowshedWeeklyReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "weeklyReport")
    private List<GuardhouseWeeklyReportEntity> guardhouseWeeklyReports = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "weeklyReport")
    private List<HenhouseWeeklyReportEntity> henhouseWeeklyReports = new ArrayList<>();
}