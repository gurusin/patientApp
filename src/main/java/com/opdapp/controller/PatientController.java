package com.opdapp.controller;

import com.opdapp.model.Patient;
import com.opdapp.model.PrescribableDrug;
import com.opdapp.service.DrugService;
import com.opdapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sudarshana on 07/08/2017.
 */
@Controller
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @Autowired
    private DrugService drugService;

    @RequestMapping(path="/getByNIC", method = RequestMethod.POST)
    public @ResponseBody Patient getByNIC(@RequestBody final String nic)
    {
        return patientService.getByNIC(nic);
    }

    @RequestMapping(path="/getByPatientId", method = RequestMethod.POST)
    public @ResponseBody Patient getByPatId(@RequestBody final String patId)
    {
        return patientService.getByPatientId(Long.parseLong(patId));
    }

    @RequestMapping(path="/savePatient", method = RequestMethod.POST)
    public @ResponseBody Patient savePatient(@RequestBody final Patient pat)
    {
        return patientService.save(pat);
    }

    @RequestMapping(path="/searchPat", method = RequestMethod.POST)
    public @ResponseBody List<Patient> findByNICLike(@RequestBody String NIC)
    {
        final List<Patient> list = patientService.findByNIC(NIC+"%");
        return list;
    }

    @RequestMapping(path="/searchPatByPhoneNo", method = RequestMethod.POST)
    public @ResponseBody List<Patient> findByPhoneNumberLike(@RequestBody String phoneNo)
    {
        final List<Patient> list = patientService.findByPhoneNoLike(phoneNo+"%");
        return list;
    }


    @RequestMapping(path="/getByPhoneNo", method = RequestMethod.POST)
    public @ResponseBody Patient getByPhoneNo(@RequestBody final String phoneNo)
    {
        return patientService.getByPhoneNo(phoneNo);
    }

    @RequestMapping(path="/findByName", method = RequestMethod.POST)
    public @ResponseBody List<Patient> findByName(@RequestBody final String name)
    {
        return patientService.findByName(name+"%");
    }

    @RequestMapping(path="/loadPatients", method = RequestMethod.GET)
    public @ResponseBody
    List<Patient> loadPatients() {
        return patientService.loadPatients();
    }

}
