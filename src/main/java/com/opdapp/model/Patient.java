package com.opdapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Patient implements Serializable {

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Id
    @GeneratedValue
    private long patientId;

    @Column
    private String nic;

    @Column
    private String phone;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String middlename;

    @Column
    private Gender gender;

    @Column
    private String allergies;

    @Column
    private String familyHistory;

    @Column
    private String socialHistory;

    private String medicalHistory;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date dateOfBirth;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String postalCode;

    @Column
    private String remarks;

    @Column
    private String profession;

    @Transient
    private String calculatedAge;

    public String getCalculatedAge() {
        return calculatedAge;
    }

    public void setCalculatedAge(String calculatedAge) {
        this.calculatedAge = calculatedAge;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {

        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @PostLoad
    public void calculateAge()
    {
       final org.joda.time.LocalDate dob = new org.joda.time.LocalDate(dateOfBirth);
       final  org.joda.time.LocalDate now = new LocalDate();
       final Period period = new Period(dob,now, PeriodType.yearMonthDay());
       calculatedAge = period.getYears() +"Y " + period.getMonths() +" M";
    }


}
