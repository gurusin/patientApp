package com.opdapp.service;

import com.opdapp.dto.BaseDrugDTO;
import com.opdapp.dto.DrugDTO;
import com.opdapp.dto.DrugPackageDTO;
import com.opdapp.dto.StrengthDTO;
import com.opdapp.model.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface DrugService {
    PrescribableDrug getByDrugId(long patId);

    List<SearchedDrug> getByBrandName(String brandName);

    List<BaseDrugDTO> findAllBaseDrugs();

    List<DrugDTO> findAllDrugs();

    List<StrengthDTO> findAllStrengths();

    List<DrugPackageDTO> findAllDrugPackages();

    DrugDTO saveDrug(final DrugDTO drugDTO);

    BaseDrugDTO saveBaseDrug(final BaseDrugDTO BaseDrugDTO);

    DrugPackageDTO saveDrugPackage(final DrugPackageDTO drugPackageDTO);
}
