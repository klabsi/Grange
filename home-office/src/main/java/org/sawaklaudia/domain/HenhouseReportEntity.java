package org.sawaklaudia.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "henhouse_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HenhouseReportEntity {

    @Id
    @Column(name = "id")
    private Long henhouseReportId;

    @Column(name = "date_of_report")
    private Instant dateOfReport;

    @Column(name = "number_of_eggs")
    private int numberOfEggs;

    @Column(name = "number_of_workers")
    private int numberOfWorkers;
}