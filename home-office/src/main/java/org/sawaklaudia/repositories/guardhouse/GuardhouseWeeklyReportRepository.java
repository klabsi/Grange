package org.sawaklaudia.repositories.guardhouse;

import org.sawaklaudia.domain.guardhouse.GuardhouseWeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardhouseWeeklyReportRepository extends JpaRepository<GuardhouseWeeklyReportEntity, Long> {
}
