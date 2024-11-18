package org.sawaklaudia.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.sawaklaudia.repositories.WeeklyReportRepositoryIntegrationTest.EXISTENT_DATE;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class WeeklyReportServiceIntegrationTest {

    @Autowired
    private WeeklyReportService weeklyReportService;

    @Autowired
    private WeeklyReportRepository weeklyReportRepository;

    @Test
    @Transactional
    public void shouldUpdateExistingWeeklyReport() {
        // given
        weeklyReportService.saveOrUpdateWeeklyReport(EXISTENT_DATE, 2, 2);

        // when
        var updatedWeeklyReport = weeklyReportRepository.findByDate(EXISTENT_DATE);

        // then
        assertEquals(2, updatedWeeklyReport.getLitersOfMilkPerWorker());
    }

    @Test
    @Transactional
    public void shouldSaveWeeklyReport() {
        // given
        LocalDate reportDate = EXISTENT_DATE.plusYears(1);
        double litersOfMilkPerWorker = 1;
        double kgOfCheesePerWorker = 1;
        weeklyReportService.saveOrUpdateWeeklyReport(reportDate, litersOfMilkPerWorker, kgOfCheesePerWorker);

        // when
        WeeklyReportEntity savedReport = weeklyReportRepository.findByDate(reportDate);

        // then
        assertNotNull(savedReport);
        assertEquals(savedReport.getDateOfReport(), reportDate);
        assertEquals(savedReport.getLitersOfMilkPerWorker(), litersOfMilkPerWorker);
    }
}
