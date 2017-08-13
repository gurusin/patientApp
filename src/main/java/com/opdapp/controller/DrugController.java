package com.opdapp.controller;

import com.opdapp.model.Drug;
import com.opdapp.model.Patient;
import com.opdapp.model.PrescribableDrug;
import com.opdapp.model.SearchedDrug;
import com.opdapp.service.DrugService;
import com.opdapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DrugController
{
    @Autowired
    private DrugService drugService;

    @RequestMapping(path="/getDrugByName", method = RequestMethod.POST)
    public @ResponseBody List<SearchedDrug> getByDrugName(@RequestBody final String drugName)
    {
        return drugService.getByBrandName(drugName);
    }

    @RequestMapping(path="/getPrescribable", method = RequestMethod.POST)
    public @ResponseBody   PrescribableDrug getByDrugId(@RequestBody final long drugId)
    {
        return drugService.getByDrugId(drugId);
    }
}
