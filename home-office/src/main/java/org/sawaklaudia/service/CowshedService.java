package org.sawaklaudia.service;

import org.sawaklaudia.domain.cowshed.CowshedReportEntity;
import org.sawaklaudia.input.CowshedInput;
import org.sawaklaudia.repositories.cowshed.CowshedReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CowshedService {

    private CowshedReportRepository cowshedReportRepository;

    @Autowired
    public CowshedService(CowshedReportRepository cowshedReportRepository) {
        this.cowshedReportRepository = cowshedReportRepository;
    }

    private void saveInput(CowshedInput cowshedInput) {
        cowshedReportRepository.save(convertToCowshedReportEntity(cowshedInput));
    }

    private static CowshedReportEntity convertToCowshedReportEntity(CowshedInput cowshedInput) {
        return CowshedReportEntity.builder()
                .dateOfReport(cowshedInput.getDateOfReport())
                .litersOfMilk(cowshedInput.getLitersOfMilk())
                .numberOfWorkers(cowshedInput.getNumberOfWorkers())
                .build();
    }

    public static CowshedInput convertToCowshedInput(CowshedReportEntity cowshedReport) {
        return CowshedInput.builder()
                .dateOfReport(cowshedReport.getDateOfReport())
                .litersOfMilk(cowshedReport.getLitersOfMilk())
                .numberOfWorkers(cowshedReport.getNumberOfWorkers())
                .build();
    }
}
