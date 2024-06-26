package ru.otus.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${rest-client.billing-base-url}")
    private String baseUrl;

    @Bean
    RestClient restClient() {
        return RestClient.create(baseUrl);
    }
}
