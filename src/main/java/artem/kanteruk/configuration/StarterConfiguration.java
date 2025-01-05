package artem.kanteruk.configuration;

import artem.kanteruk.service.WeatherService;
import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({OpenWeatherMapProperties.class})
public class StarterConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WeatherService weatherService(OpenWeatherMapProperties properties) {
        OpenWeatherMapClient client = new OpenWeatherMapClient(properties.getSdkKey());
        return new WeatherService(properties.getDefaultCity(), client);
    }
}
