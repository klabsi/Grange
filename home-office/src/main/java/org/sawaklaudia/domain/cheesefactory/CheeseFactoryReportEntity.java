package org.sawaklaudia.domain.cheesefactory;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cheese_factory_seq")
    @SequenceGenerator(name = "cheese_factory_seq", sequenceName = "cheese_factory_seq", allocationSize = 1)
    private Long cheeseFactoryReportId;

    @Column(name = "date_of_report")
    private LocalDate dateOfReport;

    @Column(name = "kg_of_cheese")
    private double kgOfCheese;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;

    @OneToOne(mappedBy = "cheeseFactoryReport")
    private CheeseFactoryWeeklyReportEntity cheeseFactoryWeeklyReport;

    @Override
    public String toString() {
        return "CheeseFactoryReportEntity{" +
                "cheeseFactoryReportId=" + cheeseFactoryReportId +
                ", dateOfReport=" + dateOfReport +
                ", kgOfCheese=" + kgOfCheese +
                ", numberOfWorkers=" + numberOfWorkers +
                '}';
    }
}