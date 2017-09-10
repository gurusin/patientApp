package com.opdapp.service.impl;

import com.opdapp.dto.issue.MakeIssue;
import com.opdapp.dto.issue.MakeIssueDetailDTO;
import com.opdapp.model.DrugPackage;
import com.opdapp.model.IssueNote;
import com.opdapp.model.IssueNoteDetails;
import com.opdapp.model.IssueStatus;
import com.opdapp.repository.DrugPackageRepository;
import com.opdapp.repository.IssueNoteRepository;
import com.opdapp.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    @Override
    public IssueNote findIssue(long issueNo) {
        return issueNoteRepository.findOne(issueNo);
    }

    @Override
    public void makeIssue(final MakeIssue issue) {
        final Map<Long,MakeIssueDetailDTO> issueMap = mapIssues(issue);
        final IssueNote issueNote = issueNoteRepository.findOne(issue.getIssueNote());
        for (final IssueNoteDetails detail : issueNote.getIssueNoteDetails())
        {
            final double issuedQty = issueMap.get(detail.getIssueNoteId()).getIssuedQty();
            detail.setBuyingQuantity(issuedQty);
            updateStock(detail.getDrugPackage(),issuedQty);
        }
        // Should this be issued ????
        issueNote.setIssueStatus(IssueStatus.PAID);
        issueNoteRepository.save(issueNote);
    }

    private void updateStock(final DrugPackage drugPackage, final double qty)
    {
        final double currentQty = drugPackage.getQuantity();
        drugPackage.setQuantity((int)(currentQty-qty));
        drugPackageRepository.save(drugPackage);
    }

    private Map<Long,MakeIssueDetailDTO> mapIssues(final MakeIssue issue)
    {
        final Map<Long,MakeIssueDetailDTO> returnMap = new HashMap<>();
        for (final MakeIssueDetailDTO dto : issue.getDetails())
        {
            returnMap.put(dto.getIssueNoteId(),dto);
        }
        return returnMap;
    }
}
