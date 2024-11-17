package org.sawaklaudia;

import org.sawaklaudia.input.CheeseFactoryInput;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.input.GuardhouseInput;
import org.sawaklaudia.input.HenhouseInput;
import org.sawaklaudia.model.*;

import java.time.LocalDate;
import java.util.List;

public class ManuallyInsertedData implements AppLaunchType {

    @Override
    public void runApp() {
        System.out.println("### biuro domowe ###");
        List<CheeseFactoryInput> cheeseFactoryInputs = generateCheeseFactoryData();
        List<CowshedInput> cowshedInputs = generateCowshedData();
        List<GuardhouseInput> guardhouseInputs = generateGuardhouseData();
        List<HenhouseInput> henhouseInputs = generateHenhouseData();

        var cheeseFactoryInputProcessor = new CheeseFactoryInputProcessor();
        var cowshedInputProcessor = new CowshedInputProcessor();
        var henhouseInputProcessor = new HenhouseInputProcessor();
        var guardhouseInputProcessor = new GuardhouseInputProcessor();

        double kgOfCheesePerMonth = cheeseFactoryInputProcessor.calculateKgOfCheesePerMonth(cheeseFactoryInputs.get(0),
                cheeseFactoryInputs.get(1), cheeseFactoryInputs.get(2), cheeseFactoryInputs.get(3));
        double literOfMilkPerMonth = cowshedInputProcessor.calcTotalLitersOfMilkPerMonth(cowshedInputs.get(0),
                cowshedInputs.get(1), cowshedInputs.get(2), cowshedInputs.get(3));
        int numberOfEggsPerMonth = henhouseInputProcessor.calculateNumOfEggsPerMonth(henhouseInputs.get(0),
                henhouseInputs.get(1), henhouseInputs.get(2), henhouseInputs.get(3));
        int numberOfFoxAttacksPerMonth = guardhouseInputProcessor.calculateNumberOfFoxAttacksPerMonth(guardhouseInputs.get(0),
                guardhouseInputs.get(1), guardhouseInputs.get(2), guardhouseInputs.get(3));

        var monthlyReportFactory = new MonthlyReportFactory();
        var monthlyReport = monthlyReportFactory.process(numberOfEggsPerMonth, literOfMilkPerMonth, numberOfFoxAttacksPerMonth, kgOfCheesePerMonth);
        System.out.println(monthlyReport.toString());

        double kgOfCheesePerWorker = cheeseFactoryInputProcessor.processKgOfCheesePerWorkerPerWeek(cheeseFactoryInputs);
        double literOfMilkPerWorker = cowshedInputProcessor.calcLitersOfMilkPerWorkerPerWeek(cowshedInputs);
        double numberOfEggsPerWorker = henhouseInputProcessor.processNumOfEggsPerWorker(henhouseInputs.get(0));
        double numberOfWorkerPerFox = guardhouseInputProcessor.processNumberOfWorkersPerFox(guardhouseInputs.get(0));
        var weeklyReportFactory = new WeeklyReportFactory();
        var weekOneReport = weeklyReportFactory.process(numberOfEggsPerWorker, literOfMilkPerWorker, numberOfWorkerPerFox, kgOfCheesePerWorker);
        System.out.println(weekOneReport.toString());
    }

    public static List<CheeseFactoryInput> generateCheeseFactoryData() {
        var cheeseFactoryInput1 = createCheeseFactoryInput(12, 7);
        var cheeseFactoryInput2 = createCheeseFactoryInput(14, 17);
        var cheeseFactoryInput3 = createCheeseFactoryInput(11, 21);
        var cheeseFactoryInput4 = createCheeseFactoryInput(10, 28);
        return List.of(cheeseFactoryInput1, cheeseFactoryInput2, cheeseFactoryInput3, cheeseFactoryInput4);
    }

    private static CheeseFactoryInput createCheeseFactoryInput(double kgOfCheesePerWeek, int dayOfMonth) {
        return CheeseFactoryInput.builder()
                .kgOfCheese(kgOfCheesePerWeek)
                .numberOfWorkers(2)
                .dateOfReport(LocalDate.of(2024, 6, dayOfMonth))
                .build();
    }

    public static List<HenhouseInput> generateHenhouseData() {
        var henhouseInput1 = createHenhouseInput(28, 7);
        var henhouseInput2 = createHenhouseInput(20, 17);
        var henhouseInput3 = createHenhouseInput(30, 21);
        var henhouseInput4 = createHenhouseInput(22, 28);
        return List.of(henhouseInput1, henhouseInput2, henhouseInput3, henhouseInput4);
    }

    private static HenhouseInput createHenhouseInput(int numberOfEggsPerWeek, int dayOfMonth) {
        return HenhouseInput.builder()
                .numberOfEggs(numberOfEggsPerWeek)
                .numberOfWorkers(4)
                .dateOfReport(LocalDate.of(2024, 6, dayOfMonth))
                .build();
    }

    public static List<GuardhouseInput> generateGuardhouseData() {
        var guardhouseInput1 = createGuardhouseInput(0, 7);
        var guardhouseInput2 = createGuardhouseInput(0, 14);
        var guardhouseInput3 = createGuardhouseInput(1, 21);
        var guardhouseInput4 = createGuardhouseInput(1, 28);
        return List.of(guardhouseInput1, guardhouseInput2, guardhouseInput3, guardhouseInput4);
    }

    private static GuardhouseInput createGuardhouseInput(int numberOfFoxAttacksPerWeek, int dayOfMonth) {
        return GuardhouseInput.builder()
                .numberOfFoxAttacks(numberOfFoxAttacksPerWeek)
                .numberOfWorkers(2)
                .dateOfReport(LocalDate.of(2024, 6, dayOfMonth))
                .build();
    }

    public static List<CowshedInput> generateCowshedData() {
        var cowshedInput1 = createCowshedInput(60, 7);
        var cowshedInput2 = createCowshedInput(58, 14);
        var cowshedInput3 = createCowshedInput(49.5, 21);
        var cowshedInput4 = createCowshedInput(55, 28);
        return List.of(cowshedInput1, cowshedInput2, cowshedInput3, cowshedInput4);
    }

    private static CowshedInput createCowshedInput(double litersOfMilkPerWeek, int dayOfMonth) {
        return CowshedInput.builder()
                .litersOfMilk(litersOfMilkPerWeek)
                .numberOfWorkers(8)
                .dateOfReport(LocalDate.of(2024, 6, dayOfMonth))
                .build();
    }
}
