package cl.duoc.MicroservicioSucursales.Config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API - Gestión de Sucursales")
                .version("1.0")
                .description("Documentación del microservicio de sucursales para Perfulandia SPA")
                .contact(new Contact()
                    .name("Equipo Stackwise")
                    .email("soportestackwise@duocuc.cl")
                    .url("https://perfulandia.cl")));
    }
}

//http://localhost:8092/swagger-ui.html