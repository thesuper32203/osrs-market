package org.anthony.osrsmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OsrsClientConfig {

    @Bean
    public WebClient osrsWebClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://prices.runescape.wiki/api/v1/osrs")
                .defaultHeader("User-Agent", "Creating a osrs item price watchlist (thesuper2021@gmail.com)")
                .build();
    }
}
