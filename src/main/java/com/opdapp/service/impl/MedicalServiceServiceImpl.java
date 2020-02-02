package com.opdapp.service.impl;

import com.opdapp.dto.DailyIncome;
import com.opdapp.dto.issue.DailyIncomeReport;
import com.opdapp.model.*;
import com.opdapp.repository.IssueNoteRepository;
import com.opdapp.repository.MedicalServiceRepository;
import com.opdapp.repository.ProductTypeRepository;
import com.opdapp.repository.ServiceIssueItemRepository;
import com.opdapp.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {

    @Autowired
    private MedicalServiceRepository medicalServiceRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Autowired
    private ServiceIssueItemRepository serviceIssueItemRepository;

    @Override
    public List<MedicalServItem> loadAllMedicalService() {
        List list = medicalServiceRepository.findAll();
        return list;
    }

    @Override
    public DailyIncomeReport getDailyIncome(DailyIncomeReport report) {
        final Map<Long, DailyIncome> dailyIncomes = new HashMap<>();
        final Map<Long, DailyIncome> servicesIncome = new HashMap<>();
        final List<IssueNote> notes = issueNoteRepository.findByIssueDateBetween(report.getFromDate(),
                report.getToDate());
        double serviceTotal = 0;
        double total = 0;
        for (final IssueNote obj : notes) {

            for (final IssueNoteDetails details : obj.getIssueNoteDetails()) {
                double value = details.getBuyingQuantity() * details.getDrugPackage().getUnitPrice();
                final long drugId = details.getDrugPackage().getDrug().getDrugId();
                DailyIncome income = dailyIncomes.get(drugId);
                if (income == null) {
                    income = new DailyIncome();
                    income.setId(drugId);
                    income.setName(details.getDrugPackage().getDrug().getBrandName());
                    dailyIncomes.put(drugId, income);
                }
                income.setAmount(income.getAmount() + value);
                total = total + value;
            }
        }

        final java.sql.Date fromDate = new java.sql.Date(report.getFromDate().getTime());
        final java.sql.Date toDate = new java.sql.Date(report.getToDate().getTime());
        final List<ServiceIssueItem> serviceIssueItems = serviceIssueItemRepository
                .findServiceIssueItemByDateBetween(fromDate,toDate);
            for (final ServiceIssueItem service : serviceIssueItems){
                double value = service.getFee();
                final long id = service.getMedicalServItem().getItemId();
                DailyIncome income = servicesIncome.get(id);
                if (income == null) {
                    income = new DailyIncome();
                    income.setId(id);
                    income.setName(service.getMedicalServItem().getItemDescription());
                    servicesIncome.put(id, income);
                }
                income.setAmount(income.getAmount() + value);
                serviceTotal = serviceTotal + value;
            }

        report.setDrugTotal(total);
        report.setServicesTotal(serviceTotal);
        report.setDrugIncome(dailyIncomes.values());
        report.setServicesIncome(servicesIncome.values());
        return report;
    }

    @Override
    public MedicalServItem save(MedicalServItem medicalServiceItem) {
        medicalServiceItem.setProductType(
                productTypeRepository.findById(medicalServiceItem.getProductType().getItemTypeId()).get());
        return medicalServiceRepository.save(medicalServiceItem);
    }

}
