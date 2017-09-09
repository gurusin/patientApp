package com.opdapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DoseFrequency {

    @Id
    @GeneratedValue
    private long doseFrequencyId;

    private String timeUnit;
    private int noofDoses;

    public long getDoseFrequencyId() {
        return doseFrequencyId;
    }

    public void setDoseFrequencyId(long doseFrequencyId) {
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
