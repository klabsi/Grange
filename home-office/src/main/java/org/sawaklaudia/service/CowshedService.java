package org.sawaklaudia.service;

import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.model.CowshedInputProcessor;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CowshedService {

    private CowshedReportRepository cowshedReportRepository;
    private CowshedWeeklyReportRepository cowshedWeeklyReportRepository;
    private CowshedInputProcessor cowshedInputProcessor;

    @Autowired
    public CowshedService(CowshedReportRepository cowshedReportRepository, CowshedWeeklyReportRepository cowshedWeeklyReportRepository, CowshedInputProcessor cowshedInputProcessor) {
        this.cowshedReportRepository = cowshedReportRepository;
        this.cowshedWeeklyReportRepository = cowshedWeeklyReportRepository;
        this.cowshedInputProcessor = cowshedInputProcessor;
    }

    private void saveInput(CowshedInput cowshedInput) {
        cowshedReportRepository.save(convertToCowshedReportEntity(cowshedInput));
    }

    public void insertIntoCowshedWeeklyReportRepo(List<Long> cowshedReportIds, Long weeklyReportId){
        cowshedWeeklyReportRepository.insertAll(cowshedReportIds, weeklyReportId);
    }

    private static CowshedReportEntity convertToCowshedReportEntity(CowshedInput cowshedInput) {
        return CowshedReportEntity.builder()
                .dateOfReport(cowshedInput.getDateOfReport())
                .litersOfMilk(cowshedInput.getLitersOfMilk())
                .numberOfWorkers(cowshedInput.getNumberOfWorkers())
                .build();
    }

    public static CowshedInput convertToCowshedInput(CowshedReportEntity cowshedReport) {
        return CowshedInput.builder()
                .dateOfReport(cowshedReport.getDateOfReport())
                .litersOfMilk(cowshedReport.getLitersOfMilk())
                .numberOfWorkers(cowshedReport.getNumberOfWorkers())
                .build();
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
}
