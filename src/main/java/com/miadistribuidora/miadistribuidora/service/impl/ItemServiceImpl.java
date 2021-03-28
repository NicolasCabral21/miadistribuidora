package com.miadistribuidora.miadistribuidora.service.impl;

import com.miadistribuidora.miadistribuidora.model.db.ItemDb;
import com.miadistribuidora.miadistribuidora.repository.ItemRepository;
import com.miadistribuidora.miadistribuidora.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDb saveItem(ItemDb item) {
        itemRepository.save(item);
        return item;
    }

    @Override
    public Optional<ItemDb> getItem(Integer idItem) {
        return itemRepository.findById(idItem);
    }

    @Override
    public List<ItemDb> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemDb updateItem(ItemDb item) {
        itemRepository.save(item);
        return item;
    }

    @Override
    public void deleteItem(Integer itemId) {
        itemRepository.deleteById(itemId);
    }
}
