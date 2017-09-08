package com.opdapp.service;


import com.opdapp.model.ItemSupplier;

import java.util.List;

public interface ItemSupplierService {
    List<ItemSupplier> loadItemSuppliers();

    ItemSupplier save(ItemSupplier itemSupplier);
}
