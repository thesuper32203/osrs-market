package org.anthony.osrsmarket.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name="items_latest_prices",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"item_id", "timeframe"})
        }
)
@Data
public class ItemLatestPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, name="item_id")
    private Integer itemId;

    @Column(nullable=false, name="time_frame")
    private String timeFrame;

    @Column(name="high_price")
    private Long highPrice;
    @Column(name="low_price")
    private Long lowPrice;

    @Column(name = "high_time")
    private Instant highTime;

    @Column(name = "low_time")
    private Instant lowTime;

    @Column(name="fetched_at")
    private Instant fetchedAt = Instant.now();
}
