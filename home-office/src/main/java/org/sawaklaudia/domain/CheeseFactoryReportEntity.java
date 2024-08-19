package org.sawaklaudia.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "cheese_factory_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CheeseFactoryReportEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cheeseFactoryReportId;

    @Column(name = "date_of_report")
    private Instant dateOfReport;

    @Column(name = "kg_of_cheese")
    private double kgOfCheese;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;

    @OneToOne(mappedBy = "cheeseFactoryReport")
    private CheeseFactoryWeeklyReportEntity cheeseFactoryWeeklyReport;
}