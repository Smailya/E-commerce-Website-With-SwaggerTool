package com.example.E_comerce.Website;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	   registry.addMapping("/**")  // Match all endpoints
           .allowedOrigins("http://localhost:3000")  // Your frontend origin
           .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow necessary HTTP methods
           .allowedHeaders("*")  // Allow all headers
           .allowCredentials(true)  // Allow cookies or authentication headers
           .maxAge(3600);  // Cache the preflight response for 1 hour
    }
}