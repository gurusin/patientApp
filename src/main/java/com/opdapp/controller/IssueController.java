package com.opdapp.controller;

import com.opdapp.dto.issue.MakeIssue;
import com.opdapp.model.IssueNote;
import com.opdapp.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IssueController {

    @Autowired
    private IssueService issueService;


    @RequestMapping(path="/prepareIssue", method = RequestMethod.POST)
    public @ResponseBody MakeIssue createIssueForPrescription(@RequestBody String prescriptionId)
    {
        return issueService.createIssueForPrescription(prescriptionId);
    }
    @RequestMapping(path="/makeIssue", method = RequestMethod.POST)
    public @ResponseBody IssueNote makeIssue(@RequestBody MakeIssue issue)
    {
        issueService.makeIssue(issue);
        return new IssueNote();
    }

    @RequestMapping(path="/findIssue", method = RequestMethod.POST)
    public @ResponseBody IssueNote findIssue(@RequestBody String issueNo)
    {
        return issueService.findIssue(Long.parseLong(issueNo));
    }
}
