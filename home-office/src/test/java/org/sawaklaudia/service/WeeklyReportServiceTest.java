package org.sawaklaudia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.repositories.WeeklyReportRepository;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WeeklyReportServiceTest {

    @Mock
    private WeeklyReportRepository weeklyReportRepository;
    @Mock
    private CowshedService cowshedService;
    @Mock
    private CheeseFactoryService cheeseFactoryService;
    private WeeklyReportService weeklyReportService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weeklyReportService = new WeeklyReportService(weeklyReportRepository,
                cowshedService, cheeseFactoryService);
    }

    @Test
    void testSaveWeeklyReport() {
        //given
        LocalDate reportDate = LocalDate.of(2024, 10, 1);
        double litersOfMilkPerWorker = 1;
        double kgOfCheesePerWorker = 1;
        WeeklyReportEntity savedWeeklyReport = new WeeklyReportEntity();

        when(weeklyReportRepository.save(any())).thenReturn(savedWeeklyReport);

        //when
        weeklyReportService.saveOrUpdateWeeklyReport(reportDate, litersOfMilkPerWorker, kgOfCheesePerWorker);

        //then
        verify(weeklyReportRepository).save(any());
    }
}