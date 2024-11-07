package org.sawaklaudia.service;

import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.input.CheeseFactoryInput;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.model.CheeseFactoryInputProcessor;
import org.sawaklaudia.model.CowshedInputProcessor;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryWeeklyReportRepository;
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
    private CheeseFactoryReportRepository cheeseFactoryReportRepository;
    private CheeseFactoryInputProcessor cheeseFactoryInputProcessor;
    private WeeklyReportRepository weeklyReportRepository;
    private CowshedWeeklyReportRepository cowshedWeeklyReportRepository;
    private CheeseFactoryWeeklyReportRepository cheeseFactoryWeeklyReportRepository;

    @Autowired
    public WeeklyReportService(CowshedReportRepository cowshedReportRepository,
                               CowshedInputProcessor cowshedInputProcessor,
                               CheeseFactoryReportRepository cheeseFactoryReportRepository,
                               CheeseFactoryInputProcessor cheeseFactoryInputProcessor,
                               WeeklyReportRepository weeklyReportRepository,
                               CowshedWeeklyReportRepository cowshedWeeklyReportRepository,
                               CheeseFactoryWeeklyReportRepository cheeseFactoryWeeklyReportRepository) {
        this.cowshedReportRepository = cowshedReportRepository;
        this.cowshedInputProcessor = cowshedInputProcessor;
        this.cheeseFactoryReportRepository = cheeseFactoryReportRepository;
        this.cheeseFactoryInputProcessor = cheeseFactoryInputProcessor;
        this.weeklyReportRepository = weeklyReportRepository;
        this.cowshedWeeklyReportRepository = cowshedWeeklyReportRepository;
        this.cheeseFactoryWeeklyReportRepository = cheeseFactoryWeeklyReportRepository;
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

    @Transactional
    public void saveOrUpdateWeeklyReport(LocalDate dateOfReport, double litersOfMilkPerWorker, double kgOfCheesePerWorker) {
        WeeklyReportEntity existingWeeklyReport = weeklyReportRepository.findByDate(dateOfReport);
        if(existingWeeklyReport != null) {
            existingWeeklyReport.setLitersOfMilkPerWorker(litersOfMilkPerWorker);
            existingWeeklyReport.setKgOfCheesePerWorker(kgOfCheesePerWorker);
            weeklyReportRepository.save(existingWeeklyReport);
        } else {
            WeeklyReportEntity weeklyReport = weeklyReportRepository
                    .save(convertToWeeklyReportEntity(dateOfReport, litersOfMilkPerWorker, kgOfCheesePerWorker));

            var weeklyReportId = weeklyReport.getWeeklyReportId();

            var cowshedReportIds = getCowshedDataFromAWeek(dateOfReport).stream()
                    .map(CowshedReportEntity::getCowshedReportId)
                    .toList();
            for (Long cowshedReportId : cowshedReportIds) {
                cowshedWeeklyReportRepository.insert(cowshedReportId, weeklyReportId);
            }

            var cheeseFactoryReportIds = getCheeseFactoryDataFromAWeek(dateOfReport).stream()
                    .map(CheeseFactoryReportEntity::getCheeseFactoryReportId)
                    .toList();
            for (Long cheeseFactoryReportId : cheeseFactoryReportIds) {
                cheeseFactoryWeeklyReportRepository.insert(cheeseFactoryReportId, weeklyReportId);
            }
        }
    }

    private WeeklyReportEntity convertToWeeklyReportEntity (LocalDate dateOfReport, double litersOfMilkPerWorker, double kgOfCheesePerWorker) {
        return WeeklyReportEntity.builder()
                .dateOfReport(dateOfReport)
                .litersOfMilkPerWorker(litersOfMilkPerWorker)
                .kgOfCheesePerWorker(kgOfCheesePerWorker)
                .build();
    }
}
