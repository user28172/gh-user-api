package com.example.ghuserdata.integration.configuration;

import com.example.ghuserdata.ApplicationBootstrap;
import com.example.ghuserdata.integration.restclient.TestApiClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {TestRestTemplateConfiguration.class, TestApiClient.class, ApplicationBootstrap.class})
public @interface IntegrationTest {
}
