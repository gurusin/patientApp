package com.opdapp.service.impl;

import com.opdapp.dto.inout.InOutDetails;
import com.opdapp.dto.inout.InOutReport;
import com.opdapp.dto.inout.InOutSearchCriteria;
import com.opdapp.model.*;
import com.opdapp.repository.GoodReceivingNoteRepository;
import com.opdapp.repository.IssueNoteRepository;
import com.opdapp.repository.ServiceIssueItemRepository;
import com.opdapp.service.InOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InOutServiceImpl implements InOutService
{
    @Autowired
    private GoodReceivingNoteRepository goodReceivingNoteRepository;

    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Autowired
    private ServiceIssueItemRepository serviceIssueItemRepository;

    @Override
    public  List<InOutReport> getInOut(final InOutSearchCriteria criteria)
    {
        final Date fromDate = criteria.getFromDate();
        final Date toDate = criteria.getToDate();
        // Get all GRNS
       final List<GoodReceivingNote> receivingNotes = goodReceivingNoteRepository
               .findGoodReceivingNoteByGrnDateBetween(new java.sql.Date(fromDate.getTime()),
                       new java.sql.Date(toDate.getTime()));

       final List<IssueNote> issueNotes = issueNoteRepository.findByIssueDateBetween(fromDate,toDate);
       final  Map<DrugPackage,List<InOutDetails>> map = getIncome(receivingNotes);
       getOutput(issueNotes,map);
       return composeInOutReport(map);
    }

    private List<InOutReport> composeInOutReport(final  Map<DrugPackage,List<InOutDetails>> map)
    {
        final List<InOutReport> out = new ArrayList<>();
        for (final Map.Entry<DrugPackage,List<InOutDetails>> entry : map.entrySet())
        {
            final InOutReport report = new InOutReport();
            report.setDrugPackage(entry.getKey());
            report.setInOutDetailsList(entry.getValue());
            out.add(report);
        }
        return out;
    }

    private void getOutput(List<IssueNote> issueNotes,final  Map<DrugPackage,List<InOutDetails>> map)
    {
        for (final IssueNote note : issueNotes)
        {
            for (final IssueNoteDetails child : note.getIssueNoteDetails())
            {
               final DrugPackage drugPackage = child.getDrugPackage();
               List<InOutDetails> list = map.get(drugPackage);
               if (list == null)
               {
                   list = new ArrayList<>();
                   map.put(drugPackage,list);
               }
               final InOutDetails details = new InOutDetails();
               details.setDate(note.getIssueDate());
               details.setIssued(child.getBuyingQuantity());
               list.add(details);
            }
        }
    }

    private Map<DrugPackage,List<InOutDetails>> getIncome(List<GoodReceivingNote> receivingNotes)
    {
        final Map<DrugPackage,List<InOutDetails>> inOut = new HashMap<>();
        for (final GoodReceivingNote grn : receivingNotes)
        {
            for (final GRNDetails child : grn.getgRNDetails())
            {
                final DrugPackage drugPackage = child.getDrugPackage();
                List<InOutDetails> list = inOut.get(drugPackage);
                if (list == null)
                {
                    list = new ArrayList<>();
                    inOut.put(drugPackage,list);
                }
                final InOutDetails details = new InOutDetails();
                details.setDate(grn.getGrnDate());
                details.setSupplierName(grn.getPurchaseOrder().getItemSupplier().getSupplierName());
                details.setReceived(child.getReceivingQty());
                list.add(details);
            }
        }
        return inOut;
    }
}
