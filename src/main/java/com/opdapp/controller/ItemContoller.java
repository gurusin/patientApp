package com.opdapp.controller;

import com.opdapp.model.Item;
import com.opdapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemContoller {
    @Autowired
    private ItemService itemService;

    @RequestMapping(path = "/saveItem", method = RequestMethod.POST)
    public @ResponseBody
    Item saveItem(@RequestBody final Item item) {
        return itemService.save(item);
    }


    @RequestMapping(path = "/loadItems", method = RequestMethod.GET)
    public @ResponseBody
    List<Item> loadItems() {
        return itemService.loadItems();
    }
}
