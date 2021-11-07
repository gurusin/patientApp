package com.opdapp.dto.dental;

import com.opdapp.model.dental.TreatmentItem;
import lombok.Data;

@Data
public class PatTreatmentDTO {

    long id;
    String timeOfAction;
    long patientId;
    String remarks;
    long rate;
    TreatmentItem treatmentItem;
}
