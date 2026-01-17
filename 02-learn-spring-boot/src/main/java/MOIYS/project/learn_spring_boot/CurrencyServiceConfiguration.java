package MOIYS.project.learn_spring_boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")
public record CurrencyServiceConfiguration(String url, String username, String key ) {
}