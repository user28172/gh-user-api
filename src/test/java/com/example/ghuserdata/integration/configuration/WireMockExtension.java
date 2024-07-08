package com.example.ghuserdata.integration.configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class WireMockExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        SpringExtension.getApplicationContext(context)
                .getBeansOfType(WireMockServer.class).values().stream().findFirst().get().start();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        SpringExtension.getApplicationContext(context)
                .getBeansOfType(WireMockServer.class).values().stream().findFirst().get().stop();

    }
}

