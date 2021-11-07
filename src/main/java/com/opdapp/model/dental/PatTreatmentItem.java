package com.opdapp.model.dental;

import com.opdapp.model.Patient;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class PatTreatmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime timeOfAction;

    private String remarks;

    @ManyToOne()
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name = "treatmentItemId")
    private TreatmentItem treatmentItem;

    private long rate;
}
