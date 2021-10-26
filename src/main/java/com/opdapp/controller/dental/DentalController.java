package com.opdapp.controller.dental;

import com.opdapp.dto.dental.PatTreatmentDTO;
import com.opdapp.model.dental.PatTreatmentItem;
import com.opdapp.model.dental.TreatmentItem;
import com.opdapp.service.dental.TreatmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DentalController {

    @Autowired
    private TreatmentItemService treatmentItemService;

    @RequestMapping(path = "/TreatmentItem", method = RequestMethod.GET)
    public @ResponseBody
    List<TreatmentItem> getTreatmentItems()
    {
       return  treatmentItemService.findAll();
    }


    @RequestMapping(path = "/TreatmentItem/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteTreatmentItem(@PathVariable("id") int id){
        treatmentItemService.deleteTreatmentItem(id);
        return 1;
    }

    @RequestMapping(path = "/TreatmentItem", method = RequestMethod.POST)
    public @ResponseBody
    TreatmentItem saveTreatmentItem(@RequestBody final TreatmentItem item)
    {
        return treatmentItemService.createTreatment(item);
    }

    @RequestMapping(path = "/PatTreatment/{patId}", method = RequestMethod.GET)
    public @ResponseBody
    List<?> getTreatmentItemsForPat(@PathVariable("patId")long patId)
    {
        return  treatmentItemService.findPatTreatment(patId);
    }

    @RequestMapping(path = "/PatTreatment", method = RequestMethod.POST)
    public @ResponseBody
    PatTreatmentItem saveTreatmentItem(@RequestBody final PatTreatmentDTO item)
    {
        return treatmentItemService.savePatTreatment(item);
    }

    @RequestMapping(path = "/PatTreatment/{Id}", method = RequestMethod.DELETE)
    public @ResponseBody
    int getTreatmentItemsForPat(@PathVariable("Id")int id)
    {
        treatmentItemService.deletePatTreatment(id);
        return 1;
    }


}
