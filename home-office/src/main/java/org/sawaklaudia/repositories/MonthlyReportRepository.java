package org.sawaklaudia.repositories;

import org.sawaklaudia.domain.MonthlyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReportEntity, Long> {
}
