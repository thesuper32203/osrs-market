package org.anthony.osrsmarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OsrsMappingItemDto {

    public long id;
    public String name;
    public String examine;
    public boolean members;
    public String icon;
    public int lowalch;
    public int highalch;

}
