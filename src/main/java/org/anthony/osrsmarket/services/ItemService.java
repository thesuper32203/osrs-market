package org.anthony.osrsmarket.services;

import org.anthony.osrsmarket.repository.ItemRepository;
import org.anthony.osrsmarket.tables.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItem(String itemName){
        return itemRepository.getByName(itemName);
    }

}
