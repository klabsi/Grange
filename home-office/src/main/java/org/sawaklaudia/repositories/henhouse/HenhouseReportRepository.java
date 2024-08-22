package org.sawaklaudia.repositories.henhouse;

import org.sawaklaudia.domain.henhouse.HenhouseReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HenhouseReportRepository extends JpaRepository<HenhouseReportEntity, Long> {
}
