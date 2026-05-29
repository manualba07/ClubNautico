/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalsprintcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("finalsprintcore")
public class CircuitoConfig {
 
    @Bean
    public static org.springframework.context.support.PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new org.springframework.context.support.PropertySourcesPlaceholderConfigurer();
    }
}
