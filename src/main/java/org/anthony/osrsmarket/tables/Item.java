package org.anthony.osrsmarket.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "items")
@Data
public class Item {


    @Id
    private Long id; // OSRS item id (from mapping)

    @Column(nullable = false)
    private String name;

    private boolean members;
    @Column(length = 2000)
    private String examine;

    private String icon;

    private Instant lastSyncedAt;

    private int lowalch;
    private int highalch;

}
