package com.opdapp.service.impl;

import com.opdapp.model.ProductType;
import com.opdapp.repository.ItemTypeRespository;
import com.opdapp.service.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {

    @Autowired
    ItemTypeRespository itemTypeRespository;

    @Override
    public List<ProductType> loadItemTypes(){
        return itemTypeRespository.findAll();
    }

    @Override
    public ProductType save(ProductType itemType){
        return  itemTypeRespository.save(itemType);
    }
}
