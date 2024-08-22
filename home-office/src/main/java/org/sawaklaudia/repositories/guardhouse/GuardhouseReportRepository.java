package org.sawaklaudia.repositories.guardhouse;

import org.sawaklaudia.domain.guardhouse.GuardhouseReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardhouseReportRepository extends JpaRepository<GuardhouseReportEntity, Long> {
}
