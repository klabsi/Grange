package org.sawaklaudia.repositories;

import org.sawaklaudia.domain.WeeklyMonthlyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyMonthlyReportRepository extends JpaRepository<WeeklyMonthlyReportEntity, Long> {
}
