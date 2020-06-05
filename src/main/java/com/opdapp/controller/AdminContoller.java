package com.opdapp.controller;

import com.opdapp.dto.StrengthDTO;
import com.opdapp.dto.common.DatePeriod;
import com.opdapp.dto.issue.DailyIncomeReport;
import com.opdapp.model.*;
import com.opdapp.model.admin.MedSysUser;
import com.opdapp.model.admin.StockAdjustmentItem;
import com.opdapp.repository.ProductTypeRepository;
import com.opdapp.service.*;
import com.opdapp.service.admin.StockAdjustmentService;
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
    private PaymentMethodService paymentMethodService;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private StockAdjustmentService stockAdjustmentService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private DrugService drugService;

    @RequestMapping(path = "/adjustStock", method = RequestMethod.POST)
    public @ResponseBody
    IssueNote adjustStock(@RequestBody final StockAdjustmentItem item)
    {
        stockAdjustmentService.adjustStock(item);
        return new IssueNote();
    }

    @RequestMapping(path = "/findAdjustments", method = RequestMethod.POST)
    public @ResponseBody
    List<StockAdjustmentItem> findAdjustments(@RequestBody final DatePeriod period)
    {
        return stockAdjustmentService.findAdjustments(period);
    }

    @RequestMapping(path = "/loadItemSuppliers", method = RequestMethod.GET)
    public @ResponseBody
    List<ItemSupplier> loadItemSuppliers() {
        return itemSupplierService.loadItemSuppliers();
    }

    @RequestMapping(path = "/saveItemSupplier", method = RequestMethod.POST)
    public @ResponseBody
    ItemSupplier saveItemSupplier(@RequestBody final ItemSupplier itemSupplier) {
        ItemSupplier save = itemSupplierService.save(itemSupplier);
        return save;
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

    @RequestMapping(path = "/getStrengthUnits", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<StrengthUnit> getStrengthUnits() {
        return unitOfMeasureService.getAllStrengthUnits();
    }


    @RequestMapping(path = "/saveStrength", method = RequestMethod.POST)
    public @ResponseBody
    List<StrengthDTO> saveStrength(@RequestBody Strength strength) {
        unitOfMeasureService.saveStrength(strength);
        return drugService.findAllStrengths();
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

    @RequestMapping(path = "/loadPaymentMethod", method = RequestMethod.GET)
    public @ResponseBody
    List<PaymentMethod> loadPaymentMethod() {
        return paymentMethodService.loadPaymentMethod();
    }

    @RequestMapping(path = "/dailyIncome", method = RequestMethod.POST)
    public @ResponseBody
    DailyIncomeReport getDailyIncome(@RequestBody DailyIncomeReport report)
    {
        return medicalServiceService.getDailyIncome(report);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public @ResponseBody MedSysUser login(@RequestBody MedSysUser medSysUser)
    {
        return loginService.login(medSysUser);
    }

}
