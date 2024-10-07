package org.sawaklaudia.service;

import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.model.CowshedInputProcessor;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeeklyReportService {

    private CowshedReportRepository cowshedReportRepository;
    private CowshedInputProcessor cowshedInputProcessor;
    private WeeklyReportRepository weeklyReportRepository;

    @Autowired
    public WeeklyReportService(CowshedReportRepository cowshedReportRepository, CowshedInputProcessor cowshedInputProcessor, WeeklyReportRepository weeklyReportRepository) {
        this.cowshedReportRepository = cowshedReportRepository;
        this.cowshedInputProcessor = cowshedInputProcessor;
        this.weeklyReportRepository = weeklyReportRepository;
    }

    public List<CowshedReportEntity> getCowshedDataFromAWeek (LocalDate dateOfReport) {
        String startDate = dateOfReport.minusDays(7).toString();
        String endDate = dateOfReport.minusDays(1).toString();
        return cowshedReportRepository.findAllReportsOfAWeek(startDate, endDate);
    }

    public double calculateWeeklyCowshedData(LocalDate dateOfReport) {
        List<CowshedReportEntity> cowshedWeeklyEntries = getCowshedDataFromAWeek(dateOfReport);
        List<CowshedInput> cowshedInputs = cowshedWeeklyEntries.stream()
                .map(CowshedService::convertToCowshedInput)
                .collect(Collectors.toList());
        return cowshedInputProcessor.calcLitersOfMilkPerWorkerPerWeek(cowshedInputs);
    }

    public void saveWeeklyReport(LocalDate dateOfReport, double litersOfMilkPerWorker) { // in the
        weeklyReportRepository.save(convertToWeeklyReportEntity(dateOfReport, litersOfMilkPerWorker));
    }

    private WeeklyReportEntity convertToWeeklyReportEntity (LocalDate dateOfReport, double litersOfMilkPerWorker) {
        return WeeklyReportEntity.builder()
                .dateOfReport(dateOfReport)
                .litersOfMilkPerPerson(litersOfMilkPerWorker)
                .build();
    }
}
