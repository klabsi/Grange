package org.sawaklaudia;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryWeeklyReportEntity;
import org.sawaklaudia.input.CheeseFactoryInput;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.input.GuardhouseInput;
import org.sawaklaudia.input.HenhouseInput;
import org.sawaklaudia.model.*;
import org.sawaklaudia.output.MonthlyReport;
import org.sawaklaudia.output.WeeklyReport;
import org.sawaklaudia.repositories.CheeseFactoryWeeklyReportRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HomeOffice {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HomeOffice.class, args);
        CheeseFactoryWeeklyReportRepository cheeseWeeklyReportRepository = context.getBean(CheeseFactoryWeeklyReportRepository.class);
        List<CheeseFactoryWeeklyReportEntity> weeklyCheeseReports = cheeseWeeklyReportRepository.findAll();
        System.out.println(weeklyCheeseReports);
    }

    public static void runApp(){
        System.out.println("### biuro domowe ###");
        List<CheeseFactoryInput> cheeseFactoryInputs = generateCheeseFactoryData();
        List<CowshedInput> cowshedInputs = generateCowshedData();
        List<GuardhouseInput> guardhouseInputs = generateGuardhouseData();
        List<HenhouseInput> henhouseInputs = generateHenhouseData();

        CheeseFactoryInputProcessor cheeseFactoryInputProcessor = new CheeseFactoryInputProcessor();
        CowshedInputProcessor cowshedInputProcessor = new CowshedInputProcessor();
        HenhouseInputProcessor henhouseInputProcessor = new HenhouseInputProcessor();
        GuardhouseInputProcessor guardhouseInputProcessor = new GuardhouseInputProcessor();

        double kgOfCheesePerMonth = cheeseFactoryInputProcessor.calculateKgOfCheesePerMonth(cheeseFactoryInputs.get(0),
                cheeseFactoryInputs.get(1), cheeseFactoryInputs.get(2), cheeseFactoryInputs.get(3));
        double literOfMilkPerMonth = cowshedInputProcessor.calculateLitersOfMilkPerMonth(cowshedInputs.get(0),
                cowshedInputs.get(1), cowshedInputs.get(2), cowshedInputs.get(3));
        int numberOfEggsPerMonth = henhouseInputProcessor.calculateNumOfEggsPerMonth(henhouseInputs.get(0),
                henhouseInputs.get(1), henhouseInputs.get(2), henhouseInputs.get(3));
        int numberOfFoxAttacksPerMonth = guardhouseInputProcessor.calculateNumberOfFoxAttacksPerMonth(guardhouseInputs.get(0),
                guardhouseInputs.get(1), guardhouseInputs.get(2), guardhouseInputs.get(3));

        MonthlyReportFactory monthlyReportFactory = new MonthlyReportFactory();
        MonthlyReport monthlyReport = monthlyReportFactory.process(numberOfEggsPerMonth, literOfMilkPerMonth, numberOfFoxAttacksPerMonth, kgOfCheesePerMonth);
        System.out.println(monthlyReport.toString());

        double kgOfCheesePerPerson = cheeseFactoryInputProcessor.processKgOfCheesePerPerson(cheeseFactoryInputs.get(0));
        double literOfMilkPerPerson = cowshedInputProcessor.processLiterOfMilkPerPerson(cowshedInputs.get(0));
        double numberOfEggsPerPerson = henhouseInputProcessor.processNumOfEggsPerPerson(henhouseInputs.get(0));
        double numberOfPersonPerFox = guardhouseInputProcessor.processNumberOfPersonPerFox(guardhouseInputs.get(0));
        WeeklyReportFactory weeklyReportFactory = new WeeklyReportFactory();
        WeeklyReport weekOneReport = weeklyReportFactory.process(numberOfEggsPerPerson, literOfMilkPerPerson, numberOfPersonPerFox, kgOfCheesePerPerson);
        System.out.println(weekOneReport.toString());
    }

    public static List<CheeseFactoryInput> generateCheeseFactoryData() {
        CheeseFactoryInput cheeseFactoryInput1 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(12)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,3))
                .build();

        CheeseFactoryInput cheeseFactoryInput2 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(11)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6, 10))
                .build();

        CheeseFactoryInput cheeseFactoryInput3 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(4)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,17))
                .build();

        CheeseFactoryInput cheeseFactoryInput4 = CheeseFactoryInput.builder()
                .kgOfCheesePerWeek(8)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,24))
                .build();

        return List.of(cheeseFactoryInput1, cheeseFactoryInput2, cheeseFactoryInput3, cheeseFactoryInput4);
    }

    public static List<HenhouseInput> generateHenhouseData() {
        HenhouseInput henhouseInput1 = HenhouseInput.builder()
                .numberOfEggsPerWeek(28)
                .numberOfWorkersPerWeek(4)
                .dateOfReport(LocalDate.of(2024, 6,3))
                .build();

        HenhouseInput henhouseInput2 = HenhouseInput.builder()
                .numberOfEggsPerWeek(20)
                .numberOfWorkersPerWeek(3)
                .dateOfReport(LocalDate.of(2024, 6,10))
                .build();

        HenhouseInput henhouseInput3 = HenhouseInput.builder()
                .numberOfEggsPerWeek(30)
                .numberOfWorkersPerWeek(4)
                .dateOfReport(LocalDate.of(2024, 6,17))
                .build();

        HenhouseInput henhouseInput4 = HenhouseInput.builder()
                .numberOfEggsPerWeek(22)
                .numberOfWorkersPerWeek(4)
                .dateOfReport(LocalDate.of(2024, 6,24))
                .build();

        return List.of(henhouseInput1, henhouseInput2, henhouseInput3, henhouseInput4);
    }

    public static List<GuardhouseInput> generateGuardhouseData() {
        GuardhouseInput guardhouseInput1 = GuardhouseInput.builder()
                .numberOfFoxAttacksPerWeek(0)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,3))
                .build();

        GuardhouseInput guardhouseInput2 = GuardhouseInput.builder()
                .numberOfFoxAttacksPerWeek(0)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,10))
                .build();

        GuardhouseInput guardhouseInput3 = GuardhouseInput.builder()
                .numberOfFoxAttacksPerWeek(1)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,17))
                .build();

        GuardhouseInput guardhouseInput4 = GuardhouseInput.builder()
                .numberOfFoxAttacksPerWeek(1)
                .numberOfWorkersPerWeek(2)
                .dateOfReport(LocalDate.of(2024, 6,24))
                .build();
        return List.of(guardhouseInput1, guardhouseInput2, guardhouseInput3, guardhouseInput4);
    }

    public static List<CowshedInput> generateCowshedData() {
        CowshedInput cowshedInput1 = CowshedInput.builder()
                .litersOfMilkPerWeek(52)
                .numberOfWorkersPerWeek(8)
                .dateOfReport(LocalDate.of(2024, 6,3))
                .build();

        CowshedInput cowshedInput2 = CowshedInput.builder()
                .litersOfMilkPerWeek(58)
                .numberOfWorkersPerWeek(9)
                .dateOfReport(LocalDate.of(2024, 6,10))
                .build();

        CowshedInput cowshedInput3 = CowshedInput.builder()
                .litersOfMilkPerWeek(50)
                .numberOfWorkersPerWeek(8)
                .dateOfReport(LocalDate.of(2024, 6,17))
                .build();

        CowshedInput cowshedInput4 = CowshedInput.builder()
                .litersOfMilkPerWeek(59)
                .numberOfWorkersPerWeek(8)
                .dateOfReport(LocalDate.of(2024, 6,24))
                .build();
        return List.of(cowshedInput1, cowshedInput2, cowshedInput3, cowshedInput4);
    }
}