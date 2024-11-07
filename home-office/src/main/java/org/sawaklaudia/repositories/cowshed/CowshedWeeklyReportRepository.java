package org.sawaklaudia.repositories.cowshed;

import org.sawaklaudia.domain.cowshed.CowshedWeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CowshedWeeklyReportRepository extends JpaRepository<CowshedWeeklyReportEntity, Long> {

    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO cowshed_weekly_report VALUES (:cowshedReportId, :weeklyReportId)")
    void insert(@Param("cowshedReportId") Long cowshedReportId, @Param("weeklyReportId") Long weeklyReportId);
}
