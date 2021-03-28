package com.miadistribuidora.miadistribuidora.service;

import com.miadistribuidora.miadistribuidora.model.db.ItemDb;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    ItemDb saveItem(ItemDb item);
    Optional<ItemDb> getItem(Integer idItem);
    List<ItemDb> getItems();
    ItemDb updateItem(ItemDb item);
    void deleteItem(Integer itemId);
}
