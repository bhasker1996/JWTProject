package org.example.jwtauth;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot JWT Project REST APIs",
                description = "Spring Boot JWT Project REST APIs description",
                version = "v1.0",
                contact = @Contact(
                        name = "Bhasker",
                        email = "bhasker.medathati@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                            description = "Spring Boot JWT Project description",
                            url = "github- URL"
        )
)
public class JwtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthApplication.class, args);
        System.out.println("Hello World");
    }

}
