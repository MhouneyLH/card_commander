package com.example.api

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(Info()
                .title("card_commander api service")
                .version("v1.0.0")
                .description("A modular monolith managing the backend stuff for the card_commander project.")
            )
    }
}