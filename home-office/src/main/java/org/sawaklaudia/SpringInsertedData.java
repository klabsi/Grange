package org.sawaklaudia;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryWeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;
import org.sawaklaudia.service.WeeklyReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class SpringInsertedData implements AppLaunchType {

    @Override
    public void runApp() {
        ConfigurableApplicationContext context = SpringApplication.run(HomeOffice.class);
        CheeseFactoryWeeklyReportRepository cheeseWeeklyReportRepository = context.getBean(CheeseFactoryWeeklyReportRepository.class);
        List<CheeseFactoryWeeklyReportEntity> weeklyCheeseReports = cheeseWeeklyReportRepository.findAll();
        System.out.println(weeklyCheeseReports);

        CowshedWeeklyReportRepository cowshedWeeklyReportRepository = context.getBean(CowshedWeeklyReportRepository.class);
        System.out.println(cowshedWeeklyReportRepository.findAll());

        CheeseFactoryReportRepository cheeseFactoryReportRepository = context.getBean(CheeseFactoryReportRepository.class);
        System.out.println(cheeseFactoryReportRepository.findAll());

        CowshedReportRepository cowshedReportRepository = context.getBean(CowshedReportRepository.class);
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 1), 5, 48));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 2), 4, 52));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 3), 6, 68));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 4), 5, 42));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 5), 5, 51));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 6), 6, 62));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 7), 5, 42));
        System.out.println("Cowshed report:");
        System.out.println(cowshedReportRepository.findAll());

        WeeklyReportRepository weeklyReportRepository = context.getBean(WeeklyReportRepository.class);
        WeeklyReportService weeklyReportService = context.getBean(WeeklyReportService.class);
        LocalDate dateOdReport = LocalDate.of(2024, 10, 8);
        double avrCowshedWorkersProductivity = weeklyReportService.calculateWeeklyCowshedData(dateOdReport);
        weeklyReportService.saveWeeklyReport(dateOdReport, avrCowshedWorkersProductivity);
        System.out.println("Weekly report:");
        System.out.println(weeklyReportRepository.findAll());
    }

    private static CowshedReportEntity buildCowshedData(LocalDate dateOfReport, int numberOfWorkers, double litersOfMilk) {
        return CowshedReportEntity.builder()
                .dateOfReport(dateOfReport)
                .numberOfWorkers(numberOfWorkers)
                .litersOfMilk(litersOfMilk)
                .build();
    }
}
