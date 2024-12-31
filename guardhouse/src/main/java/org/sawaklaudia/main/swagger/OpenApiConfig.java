package org.sawaklaudia.main.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        servers = {
                @Server(
                        description = "localhost",
                        url = "http://localhost:8084"
                )
        }
)
public class OpenApiConfig {
}
