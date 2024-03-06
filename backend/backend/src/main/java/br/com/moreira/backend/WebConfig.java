package br.com.moreira.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    // @Override
    // public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry){
    //     registry.addMapping("/**")
    //     .allowedOrigins("http://localhost:4200/")
    //     .allowedMethods("GET", "POST", "PUT", "DELETE")
    //     .allowedHeaders("*")
    //     .allowCredentials(true)
    //     .maxAge(3600);
    // }

    @Value("${cors.origins}")
	private String corsOrigins;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
			}
		};
	}
}
