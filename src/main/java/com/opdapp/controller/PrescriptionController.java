package com.opdapp.controller;

import com.opdapp.dto.PrescriptionDTO;
import com.opdapp.model.Prescription;
import com.opdapp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sudarshana on 13/08/2017.
 */
@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping(path = "savePrescription",method = RequestMethod.POST)
    public @ResponseBody String savePrescription(@RequestBody PrescriptionDTO prescriptionDTO)
    {
        prescriptionService.savePrescription(prescriptionDTO);
        return "yes";
    }

    @RequestMapping(path = "loadPrescriptions",method = RequestMethod.POST)
    public @ResponseBody List<PrescriptionDTO> loadPrescriptions(@RequestBody String patId)
    {
       return  prescriptionService.loadPrescriptions(Long.parseLong(patId));

    }

}
