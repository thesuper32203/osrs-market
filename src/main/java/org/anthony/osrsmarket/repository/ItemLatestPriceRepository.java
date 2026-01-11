package org.anthony.osrsmarket.repository;

import org.anthony.osrsmarket.tables.ItemLatestPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLatestPriceRepository extends JpaRepository<ItemLatestPrice, Long> {
}
