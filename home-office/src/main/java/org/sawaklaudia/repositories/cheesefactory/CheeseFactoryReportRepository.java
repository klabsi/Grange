package org.sawaklaudia.repositories.cheesefactory;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseFactoryReportRepository extends JpaRepository<CheeseFactoryReportEntity, Long> {
}
