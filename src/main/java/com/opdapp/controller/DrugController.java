package com.opdapp.controller;

import com.opdapp.dto.BaseDrugDTO;
import com.opdapp.dto.DrugDTO;
import com.opdapp.dto.DrugPackageDTO;
import com.opdapp.dto.StrengthDTO;
import com.opdapp.model.*;
import com.opdapp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DrugController {
    @Autowired
    private DrugService drugService;



    @RequestMapping(path = "/findDrugPackages", method = RequestMethod.POST)
    public @ResponseBody
    List<DrugPackage> findDrugPackages(@RequestBody final String drugName) {
        return drugService.findDrugPackages(drugName);
    }

    @RequestMapping(path = "/getDrugByName", method = RequestMethod.POST)
    public @ResponseBody
    List<SearchedDrug> getByDrugName(@RequestBody final String drugName) {
        return drugService.getByBrandName(drugName);
    }

    @RequestMapping(path = "/getPrescribable", method = RequestMethod.POST)
    public @ResponseBody
    PrescribableDrug getByDrugId(@RequestBody final String drugId) {
        return drugService.getByDrugId(Long.parseLong(drugId));
    }

    @RequestMapping(path = "/loadBaseDrugs", method = RequestMethod.GET)
    public @ResponseBody
    List<BaseDrugDTO> findAllBaseDrugs() {
        return drugService.findAllBaseDrugs();
    }

    @RequestMapping(path = "/loadDrugs", method = RequestMethod.GET)
    public @ResponseBody
    List<DrugDTO> findAllDrugs() {
        return drugService.findAllDrugs();
    }

    @RequestMapping(path = "/loadStrengths", method = RequestMethod.GET)
    public @ResponseBody
    List<StrengthDTO> findAllStrengths() {
        return drugService.findAllStrengths();
    }

    @RequestMapping(path = "/loadDrugPackages", method = RequestMethod.GET)
    public @ResponseBody
    List<DrugPackageDTO> findAllDrugPackages() {
        return drugService.findAllDrugPackages();
    }

    @RequestMapping(path = "/saveDrug", method = RequestMethod.POST)
    public @ResponseBody
    DrugDTO saveDrug(@RequestBody final DrugDTO drugDTO) {
        return drugService.saveDrug(drugDTO);
    }

    @RequestMapping(path = "/saveBaseDrug", method = RequestMethod.POST)
    public @ResponseBody
    BaseDrugDTO saveBaseDrug(@RequestBody final BaseDrugDTO BaseDrugDTO) {
        return drugService.saveBaseDrug(BaseDrugDTO);
    }


    @RequestMapping(path = "/saveDrugPackage", method = RequestMethod.POST)
    public @ResponseBody
    List<DrugPackageDTO> saveDrugPackage(@RequestBody final DrugPackageDTO drugPackageDTO) {
         drugService.saveDrugPackage(drugPackageDTO);
         return drugService.findAllDrugPackages();
    }
}
