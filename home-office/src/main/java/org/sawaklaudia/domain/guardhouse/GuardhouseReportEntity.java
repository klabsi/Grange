package org.sawaklaudia.domain.guardhouse;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "guardhouse_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GuardhouseReportEntity {

    @Id
    @Column(name = "id")
    private Long guardhouseReportId;

    @Column(name = "date_of_report")
    private LocalDate dateOfReport;

    @Column(name = "number_of_fox_attacks")
    private int numberOfFoxAttacks;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;

    @OneToOne(mappedBy = "guardhouseReport")
    private GuardhouseWeeklyReportEntity guardhouseWeeklyReport;

    @Override
    public String toString() {
        return "GuardhouseReportEntity{" +
                "guardhouseReportId=" + guardhouseReportId +
                ", dateOfReport=" + dateOfReport +
                ", numberOfFoxAttacks=" + numberOfFoxAttacks +
                ", numberOfWorkers=" + numberOfWorkers +
                '}';
    }
}