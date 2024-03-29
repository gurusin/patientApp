package com.opdapp.controller;

import com.opdapp.dto.PrescriptionDTO;
import com.opdapp.dto.SavedPrescriptionDTO;
import com.opdapp.dto.prescription.PrescriptionSearchDTO;
import com.opdapp.model.Prescription;
import com.opdapp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping(path = "savePrescription",method = RequestMethod.POST)
    public @ResponseBody
    Prescription savePrescription(@RequestBody PrescriptionDTO prescriptionDTO)
    {
        return prescriptionService.savePrescription(prescriptionDTO);
    }

    @RequestMapping(path = "loadPrescriptions",method = RequestMethod.POST)
    public @ResponseBody List<PrescriptionDTO> loadPrescriptions(@RequestBody String patId)
    {
       return  prescriptionService.loadPrescriptionsForPatient(Long.parseLong(patId));
    }

    @RequestMapping(path = "loadPrescriptionByDate",method = RequestMethod.POST)
    public @ResponseBody List<Prescription> loadPrescriptionsByDate(@RequestBody Date date)
    {
        return  prescriptionService.loadPrescriptionsByDate(date);

    }

    @RequestMapping(path = "prescriptionSearch",method = RequestMethod.POST)
    public @ResponseBody List<Prescription> findPrescription(@RequestBody PrescriptionSearchDTO prescriptionSearchDTO)
    {
        return  prescriptionService.findPrescriptions(prescriptionSearchDTO);

    }

     @RequestMapping(path = "getPrescription",method = RequestMethod.POST)
     public @ResponseBody Prescription getPrescription(@RequestBody String id)
     {
         return prescriptionService.get(id);
     }

    @RequestMapping(path = "getPrescriptionsForPatient",method = RequestMethod.GET)
    public @ResponseBody List<Prescription> getPrescriptionForPatientId(@RequestParam("patId") long id) {
        return prescriptionService.getFullByPatientId(id);
    }
}
