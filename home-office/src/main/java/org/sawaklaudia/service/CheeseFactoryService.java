package org.sawaklaudia.service;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.sawaklaudia.input.CheeseFactoryInput;
import org.sawaklaudia.model.CheeseFactoryInputProcessor;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryWeeklyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheeseFactoryService {

    private CheeseFactoryReportRepository cheeseFactoryReportRepository;
    private CheeseFactoryInputProcessor cheeseFactoryInputProcessor;
    private CheeseFactoryWeeklyReportRepository cheeseFactoryWeeklyReportRepository;

    @Autowired
    public CheeseFactoryService(CheeseFactoryReportRepository cheeseFactoryReportRepository, CheeseFactoryInputProcessor cheeseFactoryInputProcessor,
                                CheeseFactoryWeeklyReportRepository cheeseFactoryWeeklyReportRepository) {
        this.cheeseFactoryReportRepository = cheeseFactoryReportRepository;
        this.cheeseFactoryInputProcessor = cheeseFactoryInputProcessor;
        this.cheeseFactoryWeeklyReportRepository = cheeseFactoryWeeklyReportRepository;
    }

    public static CheeseFactoryInput convertToCheeseFactoryInput(CheeseFactoryReportEntity cheeseFactoryReport) {
        return CheeseFactoryInput.builder()
                .dateOfReport(cheeseFactoryReport.getDateOfReport())
                .kgOfCheese(cheeseFactoryReport.getKgOfCheese())
                .numberOfWorkers(cheeseFactoryReport.getNumberOfWorkers())
                .build();
    }

    public void insertIntoCheeseFactoryWeeklyReportRepo(List<Long> cheeseFactoryReportIds, Long weeklyReportId) {
        cheeseFactoryWeeklyReportRepository.insertAll(cheeseFactoryReportIds, weeklyReportId);
    }

    public List<CheeseFactoryReportEntity> getCheeseFactoryDataFromAWeek(LocalDate dateOfReport) {
        LocalDate startDate = dateOfReport.minusDays(7);
        LocalDate endDate = dateOfReport.minusDays(1);
        List<CheeseFactoryReportEntity> allReportsOfAWeek = cheeseFactoryReportRepository.findAllReportsOfAWeek(startDate, endDate);
        return filterDuplicatedCheeseFactoryDataFromAWeek(allReportsOfAWeek);
    }

    private List<CheeseFactoryReportEntity> filterDuplicatedCheeseFactoryDataFromAWeek(List<CheeseFactoryReportEntity> allReportsOfAWeek) {
        List<CheeseFactoryReportEntity> filteredReports = new ArrayList<>();
        Map<LocalDate, CheeseFactoryReportEntity> existingReports = new HashMap<>();

        for(CheeseFactoryReportEntity entity : allReportsOfAWeek) {
            LocalDate reportDate = entity.getDateOfReport();
            if(existingReports.containsKey(reportDate)) {
                CheeseFactoryReportEntity latestReport = existingReports.get(reportDate);
                long entityId = entity.getCheeseFactoryReportId();
                long latestReportId = latestReport.getCheeseFactoryReportId();
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

    public double calculateWeeklyCheeseFactoryData(LocalDate dateOfReport) {
        List<CheeseFactoryReportEntity> cheeseFactoryWeeklyEntries = getCheeseFactoryDataFromAWeek(dateOfReport);
        List<CheeseFactoryInput> cheeseFactoryInputs = cheeseFactoryWeeklyEntries.stream()
                .map(CheeseFactoryService::convertToCheeseFactoryInput)
                .toList();
        return cheeseFactoryInputProcessor.processKgOfCheesePerWorkerPerWeek(cheeseFactoryInputs);
    }
}
