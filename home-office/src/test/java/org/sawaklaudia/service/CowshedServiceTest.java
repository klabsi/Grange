package org.sawaklaudia.service;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.model.CowshedInputProcessor;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;

import java.time.LocalDate;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CowshedServiceTest {

    private CowshedService cowshedService;

    @Mock
    private CowshedReportRepository cowshedReportRepository;
    @Mock
    private CowshedWeeklyReportRepository cowshedWeeklyReportRepository;
    @Mock
    private CowshedInputProcessor cowshedInputProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cowshedService = new CowshedService(cowshedReportRepository, cowshedWeeklyReportRepository, cowshedInputProcessor);
    }

    @Test
    void shouldReturnReportWithALargerId() {
        //given
        List<CowshedReportEntity> allReports = List.of(
                createCowshedReportEntity(1L, LocalDate.of(2024, 10, 1)),
                createCowshedReportEntity(2L, LocalDate.of(2024, 10, 1))
        );

        //when
        List<CowshedReportEntity> filteredReports = cowshedService.filterDuplicatedCowshedDataFromAWeek(allReports);

        //then
        Assertions.assertEquals(1, filteredReports.size());
        Assertions.assertEquals(2, filteredReports.get(0).getCowshedReportId());
    }

    private static CowshedReportEntity createCowshedReportEntity(Long cowshedReportId, LocalDate dateOfReport) {
        return CowshedReportEntity.builder()
                .cowshedReportId(cowshedReportId)
                .dateOfReport(dateOfReport)
                .build();
    }

    @Test
    void shouldReturnTwoReports() {
        //given
        List<CowshedReportEntity> allReports = List.of(
                createCowshedReportEntity(1L, LocalDate.of(2024, 10, 1)),
                createCowshedReportEntity(2L, LocalDate.of(2024, 10, 1)),
                createCowshedReportEntity(3L, LocalDate.of(2024, 10, 1)),
                createCowshedReportEntity(4L, LocalDate.of(2024, 10, 2))
        );

        //when
        List<CowshedReportEntity> filteredReports = cowshedService.filterDuplicatedCowshedDataFromAWeek(allReports);

        //then
        Assertions.assertEquals(2, filteredReports.size());
        Assertions.assertEquals(3, filteredReports.get(0).getCowshedReportId());
    }
}
