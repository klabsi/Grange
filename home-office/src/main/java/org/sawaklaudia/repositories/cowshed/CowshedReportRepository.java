package org.sawaklaudia.repositories.cowshed;

import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CowshedReportRepository extends JpaRepository<CowshedReportEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM cowshed_report WHERE date_of_report BETWEEN :startDate AND :endDate")
    public List<CowshedReportEntity> findAllReportsOfAWeek(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
