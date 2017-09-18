package com.opdapp.controller;

import com.opdapp.dto.inout.InOutReport;
import com.opdapp.dto.inout.InOutSearchCriteria;
import com.opdapp.service.InOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InOutController {

    @Autowired
    private InOutService inOutService;

    @RequestMapping(path="/inOutReport", method = RequestMethod.POST)
    public @ResponseBody List<InOutReport> getInOut(@RequestBody final InOutSearchCriteria criteria)
    {
        return inOutService.getInOut(criteria);
    }
}
