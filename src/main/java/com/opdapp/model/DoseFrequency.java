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

    public int getDoseFrequencyId() {
        return doseFrequencyId;
    }

    public void setDoseFrequencyId(int doseFrequencyId) {
        this.doseFrequencyId = doseFrequencyId;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getNoofDoses() {
        return noofDoses;
    }

    public void setNoofDoses(int noofDoses) {
        this.noofDoses = noofDoses;
    }
}
