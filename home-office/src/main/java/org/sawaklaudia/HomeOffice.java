package org.sawaklaudia;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryWeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class HomeOffice {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HomeOffice.class, args);
        CheeseFactoryWeeklyReportRepository cheeseWeeklyReportRepository = context.getBean(CheeseFactoryWeeklyReportRepository.class);
        List<CheeseFactoryWeeklyReportEntity> weeklyCheeseReports = cheeseWeeklyReportRepository.findAll();
        System.out.println(weeklyCheeseReports);

        CowshedWeeklyReportRepository cowshedWeeklyReportRepository = context.getBean(CowshedWeeklyReportRepository.class);
        System.out.println(cowshedWeeklyReportRepository.findAll());
    }
}