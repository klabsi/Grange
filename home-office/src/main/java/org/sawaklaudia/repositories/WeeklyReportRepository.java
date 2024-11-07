package org.sawaklaudia.repositories;

import org.sawaklaudia.domain.WeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WeeklyReportRepository extends JpaRepository<WeeklyReportEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM weekly_report WHERE date_of_report = :dateOfReport")
    WeeklyReportEntity findByDate(@Param("dateOfReport") LocalDate dateOfReport);
}
