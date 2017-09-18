package com.opdapp.service.impl;

import com.opdapp.dto.DailyIncome;
import com.opdapp.dto.issue.DailyIncomeReport;
import com.opdapp.model.IssueNote;
import com.opdapp.model.IssueNoteDetails;
import com.opdapp.model.IssueNoteServiceItem;
import com.opdapp.model.MedicalServItem;
import com.opdapp.repository.IssueNoteRepository;
import com.opdapp.repository.MedicalServiceRepository;
import com.opdapp.repository.ProductTypeRepository;
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

    @Override
    public List<MedicalServItem> loadAllMedicalService() {
        List list = medicalServiceRepository.findAll();
        return list;
    }

    @Override
    public DailyIncomeReport getDailyIncome(Date date) {
        final Map<Long, DailyIncome> dailyIncomes = new HashMap<>();
        final Map<Long, DailyIncome> servicesIncome = new HashMap<>();
        final DailyIncomeReport report = new DailyIncomeReport();
        final List<IssueNote> notes = issueNoteRepository.findByIssueDate(date);
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


            for (final IssueNoteServiceItem details : obj.getIssueNoteServiceItems()){
                double value = details.getFee();
                final long id = details.getId();
                DailyIncome income = servicesIncome.get(id);
                if (income == null) {
                    income = new DailyIncome();
                    income.setId(id);
                    income.setName(details.getMedicalServItem().getItemDescription());
                    servicesIncome.put(id, income);
                }
                income.setAmount(income.getAmount() + value);
                serviceTotal = serviceTotal + value;
            }
        }
        report.setDate(date);
        report.setDrugTotal(total);
        report.setServicesTotal(serviceTotal);
        report.setDrugIncome(dailyIncomes.values());
        report.setServicesIncome(servicesIncome.values());
        return report;
    }

    @Override
    public MedicalServItem save(MedicalServItem medicalServiceItem) {
        medicalServiceItem.setProductType(
                productTypeRepository.findOne(medicalServiceItem.getProductType().getItemTypeId()));
        return medicalServiceRepository.save(medicalServiceItem);
    }
}
