package artem.kanteruk.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class EnvPostProcessor implements EnvironmentPostProcessor {

    private final YamlPropertySourceLoader yamlPropertySourceLoader;

    public EnvPostProcessor() {
        this.yamlPropertySourceLoader = new YamlPropertySourceLoader();
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var resource = new ClassPathResource("default.yaml");
        PropertySource<?> propertySource;

        try {
            propertySource = yamlPropertySourceLoader.load("openweathermap-settings", resource).get(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        environment.getPropertySources().addLast(propertySource);
    }
}
