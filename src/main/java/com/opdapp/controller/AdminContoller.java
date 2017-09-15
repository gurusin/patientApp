package com.opdapp.controller;

import com.opdapp.model.ItemSupplier;
import com.opdapp.model.MedicalServItem;
import com.opdapp.model.ProductType;
import com.opdapp.model.UnitOfMeasure;
import com.opdapp.repository.ProductTypeRepository;
import com.opdapp.service.ItemSupplierService;
import com.opdapp.service.ItemTypeService;
import com.opdapp.service.MedicalServiceService;
import com.opdapp.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminContoller {
    @Autowired
    private ItemSupplierService itemSupplierService;

    @Autowired
    private ItemTypeService itemTypeService;

    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    @Autowired
    private MedicalServiceService medicalServiceService;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @RequestMapping(path = "/loadItemSuppliers", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemSupplier> loadItemSuppliers() {
        return itemSupplierService.loadItemSuppliers();
    }

    @RequestMapping(path = "/saveItemSupplier", method = RequestMethod.POST)
    public @ResponseBody
    ItemSupplier saveItemSupplier(@RequestBody final ItemSupplier itemSupplier) {
        return itemSupplierService.save(itemSupplier);
    }

    @RequestMapping(path = "/loadItemTypes", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductType> loadItemTypes() {
        return itemTypeService.loadItemTypes();
    }

    @RequestMapping(path = "/saveItemType", method = RequestMethod.POST)
    public @ResponseBody
    ProductType saveItemType(@RequestBody final ProductType itemType) {
        return itemTypeService.save(itemType);
    }


    @RequestMapping(path = "/loadUnitOfMeasures", method = RequestMethod.GET)
    public @ResponseBody
    List<UnitOfMeasure> loadUnitOfMeasures() {
        return unitOfMeasureService.loadUnitOfMeasures();
    }


    @RequestMapping(path = "/loadMedicalItems", method = RequestMethod.GET)
    public @ResponseBody
    List<MedicalServItem> loadMedicalService() {
        List<MedicalServItem> ll = medicalServiceService.loadAllMedicalService();
        return ll;
    }

    @RequestMapping(path = "/saveMedicalServiceItem", method = RequestMethod.POST)
    public @ResponseBody
    List<MedicalServItem> saveMedicalServiceItem(@RequestBody final MedicalServItem medicalServiceItem) {
        medicalServiceService.save(medicalServiceItem);
        return medicalServiceService.loadAllMedicalService();
    }

    @RequestMapping(path = "/getProductTypes", method = RequestMethod.GET)
    public @ResponseBody Iterable<ProductType> getProductTypes()
    {
        return productTypeRepository.findAll();
    }

    @RequestMapping(path = "/getMedicalServices", method = RequestMethod.GET)
    public @ResponseBody List<MedicalServItem> getMedicalServices()
    {
        return medicalServiceService.loadAllMedicalService();
    }
}
