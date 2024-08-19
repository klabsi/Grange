package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "cowshed_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CowshedReportEntity {

    @Id
    @Column(name = "id")
    private Long cowshedReportId;

    @Column(name = "date_of_report")
    private Instant dateOfReport;

    @Column(name = "liters_of_milk")
    private double litersOfMilk;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;

    @OneToOne(mappedBy = "cowshedReport")
    private CowshedWeeklyReportEntity cowshedWeeklyReport;
}