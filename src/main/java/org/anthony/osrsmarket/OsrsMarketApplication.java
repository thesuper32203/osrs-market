package org.anthony.osrsmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OsrsMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsrsMarketApplication.class, args);
    }

}
