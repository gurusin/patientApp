package com.opdapp.service;

import com.opdapp.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> loadItems();

    Item save(Item itemSupplier);

    List<Item> findAllItems();

}
