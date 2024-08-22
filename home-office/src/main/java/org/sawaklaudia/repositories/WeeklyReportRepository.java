package org.sawaklaudia.repositories;

import org.sawaklaudia.domain.WeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyReportRepository extends JpaRepository<WeeklyReportEntity, Long> {
}
