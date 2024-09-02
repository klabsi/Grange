package org.sawaklaudia;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryWeeklyReportRepository;
import org.sawaklaudia.repositories.cowshed.CowshedWeeklyReportRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
    }
}
