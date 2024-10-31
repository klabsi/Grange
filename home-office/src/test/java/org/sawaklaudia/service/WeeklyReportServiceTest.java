package org.sawaklaudia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.model.CowshedInputProcessor;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;

import java.time.LocalDate;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WeeklyReportServiceTest {

    @Mock
    private CowshedReportRepository cowshedReportRepository;
    @Mock
    private CowshedInputProcessor cowshedInputProcessor;
    @Mock
    private WeeklyReportRepository weeklyReportRepository;
    @Mock
    private CowshedWeeklyReportRepository cowshedWeeklyReportRepository;
    private WeeklyReportService weeklyReportService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weeklyReportService = new WeeklyReportService(cowshedReportRepository, cowshedInputProcessor,
                weeklyReportRepository, cowshedWeeklyReportRepository);
    }

    @Test
    void shouldReturnReportWithALargerId() {
        //given
        List<CowshedReportEntity> allReports = List.of(
                CowshedReportEntity.builder()
                        .cowshedReportId(1L)
                        .dateOfReport(LocalDate.of(2024, 10, 01))
                        .build(),
                CowshedReportEntity.builder()
                        .cowshedReportId(2L)
                        .dateOfReport(LocalDate.of(2024, 10, 01))
                        .build()
        );

        //when
        List<CowshedReportEntity> filteredReports = weeklyReportService.filterDuplicatedCowshedDataFromAWeek(allReports);

        //then
        Assertions.assertEquals(1, filteredReports.size());
        Assertions.assertEquals(2, filteredReports.get(0).getCowshedReportId());
    }

    @Test
    void shouldReturnTwoReports() {
        //given
        List<CowshedReportEntity> allReports = List.of(
                CowshedReportEntity.builder()
                        .cowshedReportId(1L)
                        .dateOfReport(LocalDate.of(2024, 10, 01))
                        .build(),
                CowshedReportEntity.builder()
                        .cowshedReportId(2L)
                        .dateOfReport(LocalDate.of(2024, 10, 01))
                        .build(),
                CowshedReportEntity.builder()
                        .cowshedReportId(3L)
                        .dateOfReport(LocalDate.of(2024, 10, 01))
                        .build(),
                CowshedReportEntity.builder()
                        .cowshedReportId(4L)
                        .dateOfReport(LocalDate.of(2024, 10, 02))
                        .build()
        );

        //when
        List<CowshedReportEntity> filteredReports = weeklyReportService.filterDuplicatedCowshedDataFromAWeek(allReports);

        //then
        Assertions.assertEquals(2, filteredReports.size());
        Assertions.assertEquals(3, filteredReports.get(0).getCowshedReportId());
    }
}