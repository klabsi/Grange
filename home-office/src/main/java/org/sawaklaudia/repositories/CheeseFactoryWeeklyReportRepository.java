package org.sawaklaudia.repositories;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseFactoryWeeklyReportRepository extends JpaRepository <CheeseFactoryWeeklyReportEntity, Long> {
}
