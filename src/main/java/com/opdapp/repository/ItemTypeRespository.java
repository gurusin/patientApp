package com.opdapp.repository;

import com.opdapp.model.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemTypeRespository extends CrudRepository<ProductType, Long> {

    List<ProductType> findAll();
}
