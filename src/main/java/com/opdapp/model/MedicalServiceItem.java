package com.opdapp.model;


import javax.persistence.*;

@Entity
public class MedicalServiceItem {
    @Id
    @GeneratedValue
    private long itemId;

    @ManyToOne
    @JoinColumn(name = "itemTypeId")
    private ProductType productType;

    private String itemDescription;

    private double unitPrice;
}
