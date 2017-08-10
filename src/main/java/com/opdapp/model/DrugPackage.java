package com.opdapp.model;

import javax.persistence.*;

@Entity
public class DrugPackage {

    @Id
    @GeneratedValue
    private int drugPackageId;

    @ManyToOne
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "strengthId")
    private Strength strength;
    private int quantity;
}
