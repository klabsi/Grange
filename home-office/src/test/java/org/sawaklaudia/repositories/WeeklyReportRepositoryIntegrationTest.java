package org.sawaklaudia.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WeeklyReportRepositoryIntegrationTest {

    public static final Long ID_ONE = 1L;
    public static final Long NOT_EXISTENT_ID = 0L;
    public static final LocalDate EXISTENT_DATE = LocalDate.of(2024, 10, 8);

    @Autowired
    private WeeklyReportRepository weeklyReportRepository;

    @Test
    public void shouldReturnAllWeeklyReports() {
        // given & when
        var weeklyReports = weeklyReportRepository.findAll();

        // then
        assertEquals(1, weeklyReports.size());
    }

    @Test
    public void shouldReturnOneWeeklyReport() {
        // given & when
        var weeklyReport = weeklyReportRepository.findById(ID_ONE);

        // then
        assertNotNull(weeklyReport.get());
    }

    @Test
    public void shouldReturnOneWeeklyReportByDate() {
        // given & when
        var weeklyReport = weeklyReportRepository.findByDate(EXISTENT_DATE);

        // then
        assertNotNull(weeklyReport);
    }

    @Test
    public void shouldReturnNullWhenNoWeeklyReportWithSuchId() {
        // given & when
        var weeklyReport = weeklyReportRepository.findById(NOT_EXISTENT_ID);

        // then
        assertTrue(weeklyReport.isEmpty());
    }
}
