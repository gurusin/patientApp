package com.opdapp.service.dental;

import com.opdapp.dto.dental.PatTreatmentDTO;
import com.opdapp.model.dental.PatTreatmentItem;
import com.opdapp.model.dental.TreatmentItem;

import java.util.ArrayList;
import java.util.List;

public interface TreatmentItemService {

    public TreatmentItem createTreatment(TreatmentItem item );
    public List<TreatmentItem> findAll();

    List<?> findPatTreatment(long patId);
    public PatTreatmentItem savePatTreatment(PatTreatmentDTO dto);

    void deleteTreatmentItem(long id);

    void deletePatTreatment(long id);
}
