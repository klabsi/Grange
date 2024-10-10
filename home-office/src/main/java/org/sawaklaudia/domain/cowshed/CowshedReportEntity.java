package org.sawaklaudia.domain.cowshed;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cowshed_seq")
    @SequenceGenerator(name = "cowshed_seq", sequenceName = "cowshed_seq", allocationSize = 1)
    private Long cowshedReportId;

    @Column(name = "date_of_report")
    private LocalDate dateOfReport;

    @Column(name = "liters_of_milk")
    private double litersOfMilk;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;

    @OneToOne(mappedBy = "cowshedReport")
    private CowshedWeeklyReportEntity cowshedWeeklyReport;

    @Override
    public String toString() {
        return "CowshedReportEntity{" +
                "cowshedReportId=" + cowshedReportId +
                ", dateOfReport=" + dateOfReport +
                ", litersOfMilk=" + litersOfMilk +
                ", numberOfWorkers=" + numberOfWorkers +
                '}';
    }
}