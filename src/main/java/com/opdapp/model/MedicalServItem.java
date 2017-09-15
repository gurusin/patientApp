package com.opdapp.model;


import javax.persistence.*;

@Entity(name="MedicalServiceItem")
public class MedicalServItem {
    @Id
    @GeneratedValue
    private long itemId;

    @ManyToOne
    @JoinColumn(name = "itemTypeId")
    private ProductType productType;

    private String itemDescription;

    private double unitPrice;

    @Transient
    private String externalRef;

    public String getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
