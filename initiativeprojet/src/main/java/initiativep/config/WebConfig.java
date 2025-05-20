package initiativep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Bean
    public WebConfig corsConfigurer(){
        return new WebConfig() {
            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "https://localhost:8080")
                        .allowedMethods("GET", "POST", "DELETE", "OPTION")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };

    }
}
