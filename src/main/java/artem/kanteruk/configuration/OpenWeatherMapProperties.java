package artem.kanteruk.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openweathermap-settings")
public class OpenWeatherMapProperties {
    private String sdkKey;
    private String defaultCity;

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }

    public void setSdkKey(String sdkKey) {
        this.sdkKey = sdkKey;
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public String getSdkKey() {
        return sdkKey;
    }
}
