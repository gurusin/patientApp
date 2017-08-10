package com.opdapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DoseFrequency {

    @Id
    @GeneratedValue
    private int doseFrequencyId;

    private String timeUnit;
    private int noofDoses;

}
