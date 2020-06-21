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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        Drug drug = drugRepository.findById(drugId).get();
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
        durationunit.add("When Needed");
    }

    public List<SearchedDrug> getByBrandName(String brandName) {
        List<DrugPackage> searchedDrug = drugPackageRepository.findByDrugName(brandName + "%");
        //todo search in bse drug and add
        return getSearchedDrug(searchedDrug);
    }

    private List<SearchedDrug> getSearchedDrug(List<DrugPackage> drugs) {
        List<SearchedDrug> searchedDrugList = new ArrayList<SearchedDrug>();
        for (DrugPackage drug : drugs) {
            SearchedDrug searchedDrug = new SearchedDrug();
            searchedDrug.setBrandName(drug.getDrug().getBrandName());
            searchedDrug.setDrugId(drug.getDrug().getDrugId());
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
        List<DrugDTO> drugDTOList = getDrugDTOList(drugList);
        drugDTOList.sort(new Comparator<DrugDTO>() {
            @Override
            public int compare(DrugDTO o1, DrugDTO o2) {
                int val =0;
                try {
                    val= o1.getBrandName().compareTo(o2.getBrandName());
                } catch (Exception e) {
                   // Safety trap to handle null values in any error.
                }
                return val;
            }
        });
        return drugDTOList;
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
            if (drugPackage.getDrug() != null)
            {
                DrugPackageDTO drugPackageDTO = getDrugPackageDTO(drugPackage);
                packageDTOList.add(drugPackageDTO);
            }
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
        drugPackageDTO.setDrugPackageContentType(drugPackage.getDrugPackageContentType());
        return drugPackageDTO;
    }


    public DrugDTO saveDrug(final DrugDTO drugDTO) {
        Drug drug = createDrug(drugDTO);
        drug.setBaseDrug(baseDrugRepository.findById(drugDTO.getBaseDrug().getBaseDrugId()).get());
        Drug savedDrug = drugRepository.save(drug);
        return getDrugDTO(savedDrug);
    }

    private Drug createDrug(DrugDTO drugDTO) {

        Optional<Drug> optDrug = drugRepository.findById(drugDTO.getDrugId());
        Drug drug = optDrug.isPresent() ? optDrug.get() :  new Drug();
        drug.setBrandName(drugDTO.getBrandName().trim());
        drug.setLocation(drugDTO.getLocation());
        return drug;
    }

    private BaseDrug createBaseDrug(BaseDrugDTO baseDrugDTO) {
        Optional<BaseDrug> baseDrug =  baseDrugRepository.findById(baseDrugDTO.getBaseDrugId());
        BaseDrug baseDrug1 = null;
        if (!baseDrug.isPresent())
        {
            baseDrug1 = new BaseDrug();
            baseDrug1.setBaseDrugName(baseDrugDTO.getBaseDrugName());
        }else {
            baseDrug1 = baseDrug.get();
            baseDrug1.setBaseDrugName(baseDrugDTO.getBaseDrugName());
        }
        return baseDrug1;
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

    @Override
    public List<DrugPackage> findDrugPackages(String drugName) {
        return drugPackageRepository.findByDrugName(drugName+"%");
    }

    private DrugPackage getDrugPackage(DrugPackageDTO drugPackageDTO) {

        DrugPackage drugPackage =  null;
        if (drugPackageDTO.getDrugPackageId() >0)
        {
            drugPackage = drugPackageRepository.findById(drugPackageDTO.getDrugPackageId()).get();
        }
        else
        {
            drugPackage = new DrugPackage();
        }
        drugPackage.setDrug(drugRepository.findById(drugPackageDTO.getDrug().getDrugId()).get());
        drugPackage.setQuantity(drugPackageDTO.getQuantity());
        drugPackage.setStrength(getStrength(drugPackageDTO.getStrength()));
        drugPackage.setMinOrderLevel(drugPackageDTO.getMinOrderLevel());
        drugPackage.setUnitPrice(drugPackageDTO.getUnitPrice());
        drugPackage.setDrugPackageContentType(drugPackageDTO.getDrugPackageContentType());
        return drugPackage;
    }

    private Strength getStrength(StrengthDTO strengthDTO) {
        return strengthRepository.findById(strengthDTO.getStrengthId()).get();
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
        Drug drug = drugRepository.findById(drugPackage.getDrug().getDrugId()).get();
        BaseDrug basedrug = baseDrugRepository.findById(drug.getBaseDrug().getBaseDrugId()).get();
        String itemDescription = drug.getBrandName() + "(" + basedrug.getBaseDrugName() + ")";
        return itemDescription;
    }

    private String getUOM(DrugPackage drugPackage) {
        Strength strengtho = strengthRepository.findById(drugPackage.getStrength().getStrengthId()).get();
        String uom = strengtho.getStrengthUnit().getUnitName() + " " + strengtho.getStrengthAmount();
        return uom;
    }
}
