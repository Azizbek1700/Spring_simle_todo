package uz.bakhodirov.springtemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.bakhodirov.springtemplate.dto.auth.AuthCreateDto;
import uz.bakhodirov.springtemplate.enums.Role;
import uz.bakhodirov.springtemplate.properties.OpenApiProperties;
import uz.bakhodirov.springtemplate.properties.ServerProperties;
import uz.bakhodirov.springtemplate.services.auth.AuthUserService;

@SpringBootApplication
@OpenAPIDefinition
@RequiredArgsConstructor
@EnableConfigurationProperties({
        ServerProperties.class,
        OpenApiProperties.class}
)
public class SpringTemplateApplication {
    private final AuthUserService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringTemplateApplication.class, args);
    }

        @Bean
    public void run() throws Exception {
        CommandLineRunner runner=(a)->{
            service.createUser(new AuthCreateDto("Baxodirov Azizbek","admin","+9425888695","123", Role.ADMIN.name()));
        };
        runner.run("s","b");
    }

}
