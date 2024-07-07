package com.example.ghuserdata.integration.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestRestTemplateConfiguration {

    //  inject application port (pref. random)

    @Bean
    TestRestTemplate testRestTemplate() {
        return new TestRestTemplate(new RestTemplateBuilder().rootUri("http://localhost:8080/"));
    }
}
