package org.sawaklaudia.repositories.henhouse;

import org.sawaklaudia.domain.henhouse.HenhouseWeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HenhouseWeeklyReportRepository extends JpaRepository<HenhouseWeeklyReportEntity, Long> {
}
