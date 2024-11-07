package org.sawaklaudia.repositories.cheesefactory;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CheeseFactoryReportRepository extends JpaRepository<CheeseFactoryReportEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM cheese_factory_report WHERE date_of_report BETWEEN :startDate AND :endDate")
    List<CheeseFactoryReportEntity> findAllReportsOfAWeek(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
