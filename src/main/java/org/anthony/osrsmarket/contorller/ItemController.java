package org.anthony.osrsmarket.contorller;

import lombok.AllArgsConstructor;
import org.anthony.osrsmarket.component.OsrsWikiClient;
import org.anthony.osrsmarket.dto.OsrsLatestItemDto;
import org.anthony.osrsmarket.repository.ItemRepository;
import org.anthony.osrsmarket.services.ItemLatestService;
import org.anthony.osrsmarket.services.ItemMappingService;
import org.anthony.osrsmarket.tables.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final OsrsWikiClient wikiClient;
    private final ItemMappingService itemMappingService;
    private final ItemLatestService itemLatestService;

    @GetMapping("/")
    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    @GetMapping("/latest")
    public String getLatest(){
        itemLatestService.fetchItemLatest();
        return "Updated items";
    }

    @GetMapping("/generate")
    public String generate(){
        itemMappingService.syncNow();
        return "All items stored in database";
    }




}
