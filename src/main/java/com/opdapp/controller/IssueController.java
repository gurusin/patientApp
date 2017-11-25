package com.opdapp.controller;

import com.opdapp.dto.issue.MakeIssue;
import com.opdapp.model.IssueNote;
import com.opdapp.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path="/findIssueForPatient", method = RequestMethod.GET)
    public @ResponseBody Iterable<IssueNote> findIssueForPatient(@RequestParam("patientId")
                                                                     final long patientId)
    {
        return issueService.findIssueForPatient(patientId);
    }

    @RequestMapping(path="/migrateIssueNotes", method = RequestMethod.GET)
    public @ResponseBody IssueNote migrateIssues()
    {
        issueService.migrateNotes();
        return new IssueNote();
    }
}
