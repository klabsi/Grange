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
import java.util.*;

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
        List<CowshedReportEntity> allReportsOfAWeek = cowshedReportRepository.findAllReportsOfAWeek(startDate, endDate);
        return filterDuplicatedCowshedDataFromAWeek(allReportsOfAWeek);
    }
    
    public List<CowshedReportEntity> filterDuplicatedCowshedDataFromAWeek (List<CowshedReportEntity> allReportsOfAWeek) {
        List<CowshedReportEntity> filteredReports = new ArrayList<>();
        Map<LocalDate, CowshedReportEntity> existingReports = new HashMap<>();

        for(CowshedReportEntity entity : allReportsOfAWeek) {
            LocalDate reportDate = entity.getDateOfReport();
            if(existingReports.containsKey(reportDate)) {
                CowshedReportEntity latestReport = existingReports.get(reportDate);
                long entityId = entity.getCowshedReportId();
                long latestReportId = latestReport.getCowshedReportId();
                if(entityId > latestReportId) {
                    filteredReports.remove(latestReport);
                    filteredReports.add(entity);
                    existingReports.put(reportDate, entity);
                }
            } else {
                existingReports.put(reportDate, entity);
                filteredReports.add(entity);
            }
        }
        return filteredReports;
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
