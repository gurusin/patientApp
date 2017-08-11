package com.opdapp.controller;

import com.opdapp.model.Patient;
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

    @RequestMapping(path="/savePatient", method = RequestMethod.POST)
    public @ResponseBody Patient savePatient(@RequestBody final Patient pat)
    {
        return patientService.save(pat);
    }

    @RequestMapping(path="/searchPat", method = RequestMethod.POST)
    public @ResponseBody List<Patient> findByNICLike(@RequestBody String NIC)
    {
        final List<Patient> list = patientService.findByNIC(NIC+"%");
        for (final Patient o : list )
        {
            System.out.println(o.getFirstname());
        }
        return list;
    }
}
