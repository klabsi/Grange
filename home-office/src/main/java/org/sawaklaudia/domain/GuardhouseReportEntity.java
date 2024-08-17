package org.sawaklaudia.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

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
    private Instant dateOfReport;

    @Column(name = "number_of_fox_attacks")
    private int numberOfFoxAttacks;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;
}