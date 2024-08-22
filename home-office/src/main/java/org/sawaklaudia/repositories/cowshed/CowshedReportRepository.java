package org.sawaklaudia.repositories.cowshed;

import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CowshedReportRepository extends JpaRepository<CowshedReportEntity, Long> {
}
