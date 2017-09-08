package com.opdapp.repository;

import com.opdapp.model.ItemSupplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ItemSupplierRepository extends CrudRepository<ItemSupplier, Long> {

    List<ItemSupplier> findAll();
}
