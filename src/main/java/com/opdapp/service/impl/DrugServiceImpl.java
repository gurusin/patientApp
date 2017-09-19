package com.opdapp.service.impl;

import com.opdapp.dto.BaseDrugDTO;
import com.opdapp.dto.DrugDTO;
import com.opdapp.dto.DrugPackageDTO;
import com.opdapp.dto.StrengthDTO;
import com.opdapp.model.*;
import com.opdapp.repository.*;
import com.opdapp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private StrengthRepository strengthRepository;

    @Autowired
    private FrequencyRepository frequencyRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    @Autowired
    private BaseDrugRepository baseDrugRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    private List<DoseFrequency> doseFrequencies;

    private List<String> durationunit = new ArrayList<String>();

    @Autowired
    private ItemRepository itemRepository;


    public DrugServiceImpl() {

    }

    @PostConstruct
    public void init()
    {
        doseFrequencies = frequencyRepository.findAll();
        buildDurationUnits();
    }

    public PrescribableDrug getByDrugId(long drugId) {
        PrescribableDrug prescribableDrug = new PrescribableDrug();
        prescribableDrug.setDoseFrequency(doseFrequencies);
        prescribableDrug.setDurationUnit(durationunit);
        Drug drug = drugRepository.findOne(drugId);
        prescribableDrug.setDrug(drug);
        List<DrugPackage> packages = drugPackageRepository.getDrugPackageByDrug(drug);
        prescribableDrug.setPackages(packages);
        return prescribableDrug;
    }

    private void buildDurationUnits() {
        durationunit.add("Days");
        durationunit.add("Hours");
        durationunit.add("Weeks");
        durationunit.add("Months");
    }

    public List<SearchedDrug> getByBrandName(String brandName) {
        List<Drug> searchedDrug = drugRepository.findDrugsByBrandNameLike(brandName + "%");
        //todo search in bse drug and add
        return getSearchedDrug(searchedDrug);
    }

    private List<SearchedDrug> getSearchedDrug(List<Drug> drugs) {
        List<SearchedDrug> searchedDrugList = new ArrayList<SearchedDrug>();
        for (Drug drug : drugs) {
            SearchedDrug searchedDrug = new SearchedDrug();
            searchedDrug.setBrandName(drug.getBrandName());
            searchedDrug.setDrugId(drug.getDrugId());
            searchedDrugList.add(searchedDrug);
        }
        return searchedDrugList;
    }

    public List<BaseDrugDTO> findAllBaseDrugs() {
        List<BaseDrug> baseDrugList = baseDrugRepository.findAll();
        return getBaseDrugDTOList(baseDrugList);
    }

    public List<DrugDTO> findAllDrugs() {
        List<Drug> drugList = drugRepository.findAll();
        return getDrugDTOList(drugList);
    }

    public List<StrengthDTO> findAllStrengths() {
        List<Strength> strengthList = strengthRepository.findAll();
        return getStrengthDTOList(strengthList);
    }

    private List<StrengthDTO> getStrengthDTOList(List<Strength> strengthList) {
        List<StrengthDTO> strengthDTOList = new ArrayList<StrengthDTO>();
        for (Strength strength : strengthList) {
            StrengthDTO strengthDTO = getStrengthDTO(strength);
            strengthDTOList.add(strengthDTO);
        }
        return strengthDTOList;
    }

    public List<DrugPackageDTO> findAllDrugPackages() {
        List<DrugPackage> drugPackage = drugPackageRepository.findAll();
        return getDrugPackageDTOList(drugPackage);
    }

    private List<BaseDrugDTO> getBaseDrugDTOList(List<BaseDrug> baseDrugList) {
        List<BaseDrugDTO> baseDrugDTOList = new ArrayList<BaseDrugDTO>();
        for (BaseDrug baseDrug : baseDrugList) {
            BaseDrugDTO baseDrugDTO = getBaseDrugDTO(baseDrug);
            baseDrugDTOList.add(baseDrugDTO);
        }
        return baseDrugDTOList;
    }

    private BaseDrugDTO getBaseDrugDTO(BaseDrug baseDrug) {
        BaseDrugDTO baseDrugDTO = new BaseDrugDTO();
        baseDrugDTO.setBaseDrugId(baseDrug.getBaseDrugId());
        baseDrugDTO.setBaseDrugName(baseDrug.getBaseDrugName());
        return baseDrugDTO;
    }

    private List<DrugDTO> getDrugDTOList(List<Drug> drugList) {
        List<DrugDTO> drugDTOList = new ArrayList<DrugDTO>();
        for (Drug drug : drugList) {
            DrugDTO drugDTO = getDrugDTO(drug);
            drugDTOList.add(drugDTO);
        }
        return drugDTOList;
    }

    private DrugDTO getDrugDTO(Drug drug) {
        DrugDTO drugDTO = new DrugDTO();
        drugDTO.setBrandName(drug.getBrandName());
        drugDTO.setDrugId(drug.getDrugId());
        drugDTO.setBaseDrug(getBaseDrugDTO(drug.getBaseDrug()));
        drugDTO.setLocation(drug.getLocation());
        return drugDTO;
    }

    private List<DrugPackageDTO> getDrugPackageDTOList(List<DrugPackage> durgPackagelist) {
        List<DrugPackageDTO> packageDTOList = new ArrayList<DrugPackageDTO>();
        for (DrugPackage drugPackage : durgPackagelist) {
            DrugPackageDTO drugPackageDTO = getDrugPackageDTO(drugPackage);
            packageDTOList.add(drugPackageDTO);
        }
        return packageDTOList;
    }

    private StrengthDTO getStrengthDTO(Strength strength) {
        StrengthDTO strengthDTO = new StrengthDTO();
        strengthDTO.setStrengthAmount(strength.getStrengthAmount());
        strengthDTO.setStrengthId(strength.getStrengthId());
        strengthDTO.setUnitName(strength.getStrengthUnit().getUnitName());
        return strengthDTO;
    }

    private DrugPackageDTO getDrugPackageDTO(DrugPackage drugPackage) {
        DrugPackageDTO drugPackageDTO = new DrugPackageDTO();
        drugPackageDTO.setDrug(getDrugDTO(drugPackage.getDrug()));
        drugPackageDTO.setStrength(getStrengthDTO(drugPackage.getStrength()));
        drugPackageDTO.setDrugPackageId(drugPackage.getDrugPackageId());
        drugPackageDTO.setQuantity(drugPackage.getQuantity());
        drugPackageDTO.setMinOrderLevel(drugPackage.getMinOrderLevel());
        drugPackageDTO.setUnitPrice(drugPackage.getUnitPrice());
        return drugPackageDTO;
    }


    public DrugDTO saveDrug(final DrugDTO drugDTO) {
        Drug drug = createDrug(drugDTO);
        drug.setBaseDrug(baseDrugRepository.findOne(drug.getBaseDrug().getBaseDrugId()));
        Drug savedDrug = drugRepository.save(drug);
        return getDrugDTO(savedDrug);
    }

    private Drug createDrug(DrugDTO drugDTO) {
        Drug drug = new Drug();
        drug.setBaseDrug(createBaseDrug(drugDTO.getBaseDrug()));
        drug.setBrandName(drugDTO.getBrandName());
        drug.setDrugId(drugDTO.getDrugId());
        drug.setLocation(drugDTO.getLocation());
        return drug;
    }

    private BaseDrug createBaseDrug(BaseDrugDTO baseDrugDTO) {
        BaseDrug basedrug = new BaseDrug();
        basedrug.setBaseDrugId(baseDrugDTO.getBaseDrugId());
        basedrug.setBaseDrugName(baseDrugDTO.getBaseDrugName());
        return basedrug;
    }

    public BaseDrugDTO saveBaseDrug(final BaseDrugDTO baseDrugDTO) {
        BaseDrug baseDrug = createBaseDrug(baseDrugDTO);
        BaseDrug savedBaseDrug = baseDrugRepository.save(baseDrug);
        return getBaseDrugDTO(savedBaseDrug);
    }

    public DrugPackageDTO saveDrugPackage(final DrugPackageDTO drugPackageDTO) {
        DrugPackage drugPackage = getDrugPackage(drugPackageDTO);
        DrugPackage savedDrugPackage = drugPackageRepository.save(drugPackage);
        saveItem(savedDrugPackage);
        return getDrugPackageDTO(savedDrugPackage);
    }

    private DrugPackage getDrugPackage(DrugPackageDTO drugPackageDTO) {

        DrugPackage drugPackage =  null;
        if (drugPackageDTO.getDrugPackageId() >0)
        {
            drugPackage = drugPackageRepository.findOne(drugPackageDTO.getDrugPackageId());
        }
        else
        {
            drugPackage = new DrugPackage();
        }
        drugPackage.setDrug(drugRepository.findOne(drugPackageDTO.getDrug().getDrugId()));
        drugPackage.setQuantity(drugPackageDTO.getQuantity());
        drugPackage.setStrength(getStrength(drugPackageDTO.getStrength()));
        drugPackage.setMinOrderLevel(drugPackageDTO.getMinOrderLevel());
        drugPackage.setUnitPrice(drugPackageDTO.getUnitPrice());
        return drugPackage;
    }

    private Strength getStrength(StrengthDTO strengthDTO) {
        return strengthRepository.findOne(strengthDTO.getStrengthId());
    }

    private void saveItem(final DrugPackage drugPackage) {
        Item item = new Item();

        item.setItemDescription(getItemDescription(drugPackage));
        item.setMinOrderLevel(drugPackage.getMinOrderLevel());
        ProductType productType = new ProductType();
        productType.setItemTypeId(1);
        item.setProductType(productType);
        item.setQuantity(drugPackage.getQuantity());
        item.setUnitPrice(drugPackage.getUnitPrice());
        String strength = getUOM(drugPackage);
        UnitOfMeasure uom = unitOfMeasureRepository.getUnitOfMeasuresByUnitOfMeasureLike(strength);
        if (uom == null) {
            uom = new UnitOfMeasure();
            uom.setUnitOfMeasure(strength);
            uom = unitOfMeasureRepository.save(uom);
        }
        item.setUnitOfMeasure(uom);
        itemRepository.save(item);
    }

    private String getItemDescription(DrugPackage drugPackage) {
        Drug drug = drugRepository.findOne(drugPackage.getDrug().getDrugId());
        BaseDrug basedrug = baseDrugRepository.findOne(drug.getBaseDrug().getBaseDrugId());
        String itemDescription = drug.getBrandName() + "(" + basedrug.getBaseDrugName() + ")";
        return itemDescription;
    }

    private String getUOM(DrugPackage drugPackage) {
        Strength strengtho = strengthRepository.findOne(drugPackage.getStrength().getStrengthId());
        String uom = strengtho.getStrengthUnit().getUnitName() + " " + strengtho.getStrengthAmount();
        return uom;
    }
}
