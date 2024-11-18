package org.sawaklaudia.repositories.cheesefactory;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseFactoryWeeklyReportRepository extends JpaRepository<CheeseFactoryWeeklyReportEntity, Long> {

    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO cheese_factory_weekly_report VALUES (:cheeseFactoryReportId, :weeklyReportId)")
    void insert(@Param("cheeseFactoryReportId") Long cheeseFactoryReportId, @Param("weeklyReportId") Long weeklyReportId);
}
