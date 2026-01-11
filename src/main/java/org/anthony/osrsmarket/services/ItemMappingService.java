package org.anthony.osrsmarket.services;


import lombok.AllArgsConstructor;
import org.anthony.osrsmarket.component.OsrsWikiClient;
import org.anthony.osrsmarket.dto.OsrsMappingItemDto;
import org.anthony.osrsmarket.repository.ItemRepository;
import org.anthony.osrsmarket.tables.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemMappingService {

    private final ItemRepository itemRepository;
    private final OsrsWikiClient osrsWikiClient;

    @Transactional
    public void syncNow(){

        List<OsrsMappingItemDto> items = osrsWikiClient.fetchMapping().block();
        if(items == null || items.isEmpty()){ return;}

        Instant now = Instant.now();
        List<Item> toSave = new ArrayList<>(items.size());

        for(OsrsMappingItemDto item : items){
            Item save = new Item();
            save.setId(item.id);
            save.setName(item.name);
            save.setExamine(item.examine);
            save.setMembers(item.members);
            save.setIcon(item.icon);
            save.setHighalch(item.highalch);
            save.setLowalch(item.lowalch);
            save.setLastSyncedAt(now);
            save.setMembers(item.members);
            toSave.add(save);
        }

        itemRepository.saveAll(toSave);
    }

}
