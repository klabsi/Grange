package org.sawaklaudia.repositories;

import org.sawaklaudia.domain.cowshed.CowshedWeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CowshedWeeklyReportRepository extends JpaRepository <CowshedWeeklyReportEntity, Long> {
}
