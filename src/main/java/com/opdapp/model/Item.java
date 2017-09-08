package com.opdapp.model;


import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private long itemId;

    @ManyToOne
    @JoinColumn(name = "itemTypeId")
    private ProductType productType;

    private String itemDescription;

    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "unitOfMeasureId")
    private UnitOfMeasure unitOfMeasure;

    private double minOrderLevel;
    private double quantity;

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    public double getMinOrderLevel() {
        return minOrderLevel;
    }

    public void setMinOrderLevel(double minOrderLevel) {
        this.minOrderLevel = minOrderLevel;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
