package com.opdapp.service.impl;

import com.opdapp.model.Item;
import com.opdapp.repository.ItemRepository;
import com.opdapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAllItems() {
        return (itemRepository.findAll());
    }

    @Override
    public List<Item> loadItems() {
        List<Item> list = itemRepository.findAll();
        return list;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
