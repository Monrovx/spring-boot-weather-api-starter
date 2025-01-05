package artem.kanteruk.service;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.Temperature;
import com.github.prominence.openweathermap.api.request.weather.CurrentWeatherRequester;
import com.github.prominence.openweathermap.api.request.weather.single.SingleResultCurrentWeatherRequestTerminator;

public class WeatherService {
    private final String targetCity;
    private final OpenWeatherMapClient client;

    public WeatherService(String targetCity, OpenWeatherMapClient openWeatherMapClient) {
        this.targetCity = targetCity;
        this.client = openWeatherMapClient;
    }

    public String getTemperature() {
        CurrentWeatherRequester requester = client.currentWeather();

        SingleResultCurrentWeatherRequestTerminator terminator = requester.single()
                .byCityName(targetCity)
                .unitSystem(UnitSystem.METRIC)
                .retrieve();

        Temperature temperature = terminator.asJava().getTemperature();
        return temperature.toString();
    }
}
