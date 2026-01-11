package org.anthony.osrsmarket.services;

import lombok.AllArgsConstructor;
import org.anthony.osrsmarket.component.OsrsWikiClient;
import org.anthony.osrsmarket.dto.OsrsLatestItemDto;
import org.anthony.osrsmarket.repository.ItemLatestPriceRepository;
import org.anthony.osrsmarket.tables.ItemLatestPrice;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ItemLatestService {

    private final OsrsWikiClient osrsWikiClient;
    private final ItemLatestPriceRepository itemLatestPrice;

    public void fetchItemLatest() {
        Map<String, OsrsLatestItemDto> entity = osrsWikiClient.fetchLatest().block();

        if (entity == null || entity.isEmpty()) {return;}
        List<ItemLatestPrice> save = new ArrayList<>(entity.size());

        for(Map.Entry<String, OsrsLatestItemDto> entry : entity.entrySet()) {
            OsrsLatestItemDto e = entry.getValue();
            if (e.getLow() == null || e.getHigh() == null) {
                continue;
            }
            ItemLatestPrice item = new ItemLatestPrice();
            item.setItemId(Integer.parseInt(entry.getKey()));
            item.setLow(e.getLow());
            item.setHigh(e.getHigh());
            item.setHighTime(Instant.ofEpochSecond(e.getHighTime()));
            item.setLowTime(Instant.ofEpochSecond(e.getLowTime()));
            item.setLastUpdate(Instant.now());
            save.add(item);
        }

        itemLatestPrice.saveAll(save);

    }
}
