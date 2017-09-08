package com.opdapp.service.impl;

import com.opdapp.model.ItemSupplier;
import com.opdapp.repository.ItemSupplierRepository;
import com.opdapp.service.ItemSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ItemSupplierService {

    @Autowired
    ItemSupplierRepository itemSupplierRepository;

    @Override
    public List<ItemSupplier> loadItemSuppliers() {
            List<ItemSupplier> list = itemSupplierRepository.findAll();
        return list;
    }

    @Override
    public ItemSupplier save(ItemSupplier itemSupplier){
        return itemSupplierRepository.save(itemSupplier);
    }
}
