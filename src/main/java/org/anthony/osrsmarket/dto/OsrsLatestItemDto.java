package org.anthony.osrsmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OsrsLatestItemDto {

    private Long high;
    private Long highTime;

    private Long low;
    private Long lowTime;

}
