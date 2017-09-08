package com.opdapp.service;

import com.opdapp.model.ProductType;

import java.util.List;

public interface ItemTypeService {
    List<ProductType> loadItemTypes();

    ProductType save(ProductType itemType);
}
