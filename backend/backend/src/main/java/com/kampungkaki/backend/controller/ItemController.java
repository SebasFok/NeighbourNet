package com.kampungkaki.backend.controller;

import com.kampungkaki.backend.model.Item;
import com.kampungkaki.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:5173") // Allows your Vue app to talk to this API
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PatchMapping("/{id}/toggle")
    public Item toggleAvailability(@PathVariable Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setAvailable(!item.isAvailable());
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}