package org.anthony.osrsmarket.component;

import org.anthony.osrsmarket.dto.OsrsLatestItemDto;
import org.anthony.osrsmarket.dto.OsrsMappingItemDto;
import org.anthony.osrsmarket.dto.OsrsResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class OsrsWikiClient {

    private final WebClient webClient;

    public OsrsWikiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<OsrsMappingItemDto>> fetchMapping(){
        return webClient
                .get()
                .uri("/mapping")
                .retrieve()
                .bodyToFlux(OsrsMappingItemDto.class)
                .collectList();
    }

    public Mono<Map<String, OsrsLatestItemDto>> fetchLatest(){
        return webClient
                .get()
                .uri("/latest")
                .retrieve()
                .bodyToMono(OsrsResponseDto.class)
                .map(OsrsResponseDto::getData);
    }
}
