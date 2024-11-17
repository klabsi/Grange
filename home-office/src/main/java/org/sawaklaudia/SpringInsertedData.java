package org.sawaklaudia;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.repositories.WeeklyReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryReportRepository;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryWeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.sawaklaudia.service.CheeseFactoryService;
import org.sawaklaudia.service.CowshedService;
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

        insertCheeseFactoryData(context);
        insertCowshedData(context);

        WeeklyReportRepository weeklyReportRepository = context.getBean(WeeklyReportRepository.class);
        WeeklyReportService weeklyReportService = context.getBean(WeeklyReportService.class);
        CowshedService cowshedService = context.getBean(CowshedService.class);
        CheeseFactoryService cheeseFactoryService = context.getBean(CheeseFactoryService.class);
        LocalDate dateOfReport = LocalDate.of(2024, 10, 8);
        double avrCowshedWorkersProductivity = cowshedService.calculateWeeklyCowshedData(dateOfReport);
        double avrCheeseFactoryWorkersProductivity = cheeseFactoryService.calculateWeeklyCheeseFactoryData(dateOfReport);
        weeklyReportService.saveOrUpdateWeeklyReport(dateOfReport, avrCowshedWorkersProductivity, avrCheeseFactoryWorkersProductivity);
        System.out.println("Weekly report:");
        System.out.println(weeklyReportRepository.findAll());
    }

    private void insertCowshedData(ConfigurableApplicationContext context) {
        CowshedReportRepository cowshedReportRepository = context.getBean(CowshedReportRepository.class);
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 1), 5, 2255));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 2), 4, 52));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 3), 6, 68));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 4), 5, 33));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 5), 5, 51));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 6), 6, 62));
        cowshedReportRepository.save(buildCowshedData(LocalDate.of(2024, 10, 7), 5, 42));
        System.out.println("Cowshed report:");
        System.out.println(cowshedReportRepository.findAll());
    }

    private void insertCheeseFactoryData(ConfigurableApplicationContext context) {
        CheeseFactoryReportRepository cheeseFactoryReportRepository = context.getBean(CheeseFactoryReportRepository.class);
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 1), 5, 28));
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 2), 4, 42));
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 3), 6, 58));
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 4), 5, 52));
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 5), 5, 41));
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 6), 6, 62));
        cheeseFactoryReportRepository.save(buildCheeseFactoryData(LocalDate.of(2024, 10, 7), 5, 52));
        System.out.println("Cheese Factory report:");
        System.out.println(cheeseFactoryReportRepository.findAll());
    }

    private CheeseFactoryReportEntity buildCheeseFactoryData(LocalDate dateOfReport, int numberOfWorkers, double kgOfCheese) {
        return CheeseFactoryReportEntity.builder()
                .dateOfReport(dateOfReport)
                .numberOfWorkers(numberOfWorkers)
                .kgOfCheese(kgOfCheese)
                .build();
    }

    private static CowshedReportEntity buildCowshedData(LocalDate dateOfReport, int numberOfWorkers, double litersOfMilk) {
        return CowshedReportEntity.builder()
                .dateOfReport(dateOfReport)
                .numberOfWorkers(numberOfWorkers)
                .litersOfMilk(litersOfMilk)
                .build();
    }
}
