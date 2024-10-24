package org.sawaklaudia.service;

import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.model.CowshedInputProcessor;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeeklyReportService {

    private CowshedReportRepository cowshedReportRepository;
    private CowshedInputProcessor cowshedInputProcessor;
    private WeeklyReportRepository weeklyReportRepository;
    private CowshedWeeklyReportRepository cowshedWeeklyReportRepository;

    @Autowired
    public WeeklyReportService(CowshedReportRepository cowshedReportRepository,
                               CowshedInputProcessor cowshedInputProcessor,
                               WeeklyReportRepository weeklyReportRepository,
                               CowshedWeeklyReportRepository cowshedWeeklyReportRepository) {
        this.cowshedReportRepository = cowshedReportRepository;
        this.cowshedInputProcessor = cowshedInputProcessor;
        this.weeklyReportRepository = weeklyReportRepository;
        this.cowshedWeeklyReportRepository = cowshedWeeklyReportRepository;
    }

    public List<CowshedReportEntity> getCowshedDataFromAWeek (LocalDate dateOfReport) {
        LocalDate startDate = dateOfReport.minusDays(7);
        LocalDate endDate = dateOfReport.minusDays(1);
        return cowshedReportRepository.findAllReportsOfAWeek(startDate, endDate);
    }

    public double calculateWeeklyCowshedData(LocalDate dateOfReport) {
        List<CowshedReportEntity> cowshedWeeklyEntries = getCowshedDataFromAWeek(dateOfReport);
        List<CowshedInput> cowshedInputs = cowshedWeeklyEntries.stream()
                .map(CowshedService::convertToCowshedInput)
                .toList();
        return cowshedInputProcessor.calcLitersOfMilkPerWorkerPerWeek(cowshedInputs);
    }

    @Transactional
    public void saveWeeklyReport(LocalDate dateOfReport, double litersOfMilkPerWorker) {
        WeeklyReportEntity weeklyReportEntity = weeklyReportRepository.save(convertToWeeklyReportEntity(dateOfReport, litersOfMilkPerWorker));
        var weeklyReportId = weeklyReportEntity.getWeeklyReportId();
        var cowshedReportIds = getCowshedDataFromAWeek(dateOfReport).stream()
                .map(CowshedReportEntity::getCowshedReportId)
                .toList();
        for (Long cowshedReportId : cowshedReportIds) {
           cowshedWeeklyReportRepository.insert(cowshedReportId, weeklyReportId);
        }

    }

    private WeeklyReportEntity convertToWeeklyReportEntity (LocalDate dateOfReport, double litersOfMilkPerWorker) {
        return WeeklyReportEntity.builder()
                .dateOfReport(dateOfReport)
                .litersOfMilkPerPerson(litersOfMilkPerWorker)
                .build();
    }
}
