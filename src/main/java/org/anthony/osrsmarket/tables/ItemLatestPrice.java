package org.anthony.osrsmarket.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name="items_latest_prices")
@Data
public class ItemLatestPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false, name="item_id", unique = true)
    private Integer itemId;
    private Long high;
    private Long low;
    @Column(name = "high_time")
    private Instant highTime;
    @Column(name = "low_time")
    private Instant lowTime;
    private Instant lastUpdate;
}
