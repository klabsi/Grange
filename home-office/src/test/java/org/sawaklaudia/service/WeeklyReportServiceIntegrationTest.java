package org.sawaklaudia.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sawaklaudia.domain.WeeklyReportEntity;
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

    @Test
    @Transactional
    public void shouldUpdateExistingWeeklyReport() {
        // given & when
        double litersOfMilkPerWorker = 2;
        double kgOfCheesePerWorker = 2;
        weeklyReportService.saveOrUpdateWeeklyReport(EXISTENT_DATE, litersOfMilkPerWorker, kgOfCheesePerWorker);

        // then
        var updatedWeeklyReport = weeklyReportService.getWeeklyReportByDate(EXISTENT_DATE);
        assertEquals(litersOfMilkPerWorker, updatedWeeklyReport.getLitersOfMilkPerWorker());
    }

    @Test
    @Transactional
    public void shouldSaveWeeklyReport() {
        // given
        LocalDate reportDate = EXISTENT_DATE.plusYears(1);
        double litersOfMilkPerWorker = 1;
        double kgOfCheesePerWorker = 1;

        // when
        weeklyReportService.saveOrUpdateWeeklyReport(reportDate, litersOfMilkPerWorker, kgOfCheesePerWorker);

        // then
        WeeklyReportEntity savedReport = weeklyReportService.getWeeklyReportByDate(reportDate);
        assertNotNull(savedReport);
        assertEquals(savedReport.getDateOfReport(), reportDate);
        assertEquals(savedReport.getLitersOfMilkPerWorker(), litersOfMilkPerWorker);
    }
}
