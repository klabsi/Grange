package org.sawaklaudia.service;

import org.sawaklaudia.domain.cheesefactory.CheeseFactoryReportEntity;
import org.sawaklaudia.input.CheeseFactoryInput;
import org.sawaklaudia.repositories.cheesefactory.CheeseFactoryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheeseFactoryService {

    private CheeseFactoryReportRepository cheeseFactoryReportRepository;

    @Autowired
    public CheeseFactoryService(CheeseFactoryReportRepository cheeseFactoryReportRepository) {
        this.cheeseFactoryReportRepository = cheeseFactoryReportRepository;
    }

    public static CheeseFactoryInput convertToCheeseFactoryInput(CheeseFactoryReportEntity cheeseFactoryReport) {
        return CheeseFactoryInput.builder()
                .dateOfReport(cheeseFactoryReport.getDateOfReport())
                .kgOfCheese(cheeseFactoryReport.getKgOfCheese())
                .numberOfWorkers(cheeseFactoryReport.getNumberOfWorkers())
                .build();
    }
}
