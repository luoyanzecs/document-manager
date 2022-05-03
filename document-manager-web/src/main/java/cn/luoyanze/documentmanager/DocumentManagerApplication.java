package cn.luoyanze.documentmanager;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DocumentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentManagerApplication.class, args);
    }

    @Configuration
    public static class CorsConfig {

        @Bean
        public WebMvcConfigurer corsBean() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(@NotNull CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOriginPatterns("*")
                            .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                            .allowCredentials(true)
                            .maxAge(3600)
                            .allowedHeaders("*");
                }
            };
        }
    }
}
