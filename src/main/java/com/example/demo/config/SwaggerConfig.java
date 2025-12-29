package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                // 1. Metadata for the UI
                .info(new Info()
                        .title("Demo API")
                        .version("1.0")
                        .description("Spring Boot 3 JWT Authentication API"))
                
                // 2. Global "Authorize" button
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                
                // 3. Define the Security Scheme
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                
                // 4. Server Configuration
                // IMPORTANT: If your proxy handles the "/api" prefix, keep it. 
                // If not, use the base URL.
                .servers(List.of(
                        new Server().url("https://9081.408procr.amypo.ai/").description("Default Server")
                ));
    }
}