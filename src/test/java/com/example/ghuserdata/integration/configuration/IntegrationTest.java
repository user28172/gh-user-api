package com.example.ghuserdata.integration.configuration;

import com.example.ghuserdata.ApplicationBootstrap;
import com.example.ghuserdata.integration.database.TestCountersRepository;
import com.example.ghuserdata.integration.restclient.TestApiClient;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(WireMockExtension.class)
@Profile("integration")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {TestRestTemplateConfiguration.class,
                TestApiClient.class,
                ApplicationBootstrap.class,
                WireMockConfiguration.class,
                TestCountersRepository.class})
public @interface IntegrationTest {
}
