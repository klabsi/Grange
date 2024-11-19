package org.sawaklaudia.service;

import org.sawaklaudia.domain.WeeklyReportEntity;
import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class WeeklyReportService {

    private WeeklyReportRepository weeklyReportRepository;
    private CowshedService cowshedService;
    private CheeseFactoryService cheeseFactoryService;

    @Autowired
    public WeeklyReportService(WeeklyReportRepository weeklyReportRepository,
                               CowshedService cowshedService,
                               CheeseFactoryService cheeseFactoryService) {
        this.weeklyReportRepository = weeklyReportRepository;
        this.cowshedService = cowshedService;
        this.cheeseFactoryService = cheeseFactoryService;
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
            saveIntoCowshedWeeklyReportRepo(dateOfReport, weeklyReportId);
            saveIntoCheeseFactoryWeeklyReportRepo(dateOfReport, weeklyReportId);
        }
    }

    private void saveIntoCowshedWeeklyReportRepo(LocalDate dateOfReport, Long weeklyReportId) {
        var cowshedReportIds = cowshedService.getCowshedDataFromAWeek(dateOfReport).stream()
                .map(CowshedReportEntity::getCowshedReportId)
                .toList();
        for (Long cowshedReportId : cowshedReportIds) {
            cowshedService.insertIntoCowshedWeeklyReportRepo(cowshedReportId, weeklyReportId);
        }
    }

    private void saveIntoCheeseFactoryWeeklyReportRepo(LocalDate dateOfReport, Long weeklyReportId) {
        var cheeseFactoryReportIds = cheeseFactoryService.getCheeseFactoryDataFromAWeek(dateOfReport).stream()
                .map(CheeseFactoryReportEntity::getCheeseFactoryReportId)
                .toList();
        for (Long cheeseFactoryReportId : cheeseFactoryReportIds) {
            cheeseFactoryService.insertIntoCheeseFactoryWeeklyReportRepo(cheeseFactoryReportId, weeklyReportId);
        }
    }

    private WeeklyReportEntity convertToWeeklyReportEntity (LocalDate dateOfReport, double litersOfMilkPerWorker, double kgOfCheesePerWorker) {
        return WeeklyReportEntity.builder()
                .dateOfReport(dateOfReport)
                .litersOfMilkPerWorker(litersOfMilkPerWorker)
                .kgOfCheesePerWorker(kgOfCheesePerWorker)
                .build();
    }

    public WeeklyReportEntity getWeeklyReportByDate(LocalDate dateOfReport) {
        return weeklyReportRepository.findByDate(dateOfReport);
    }
}
