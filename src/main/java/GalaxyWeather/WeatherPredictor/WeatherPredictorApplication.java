package GalaxyWeather.WeatherPredictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"GalaxyWeather.WeatherPredictor.repository"})
public class WeatherPredictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherPredictorApplication.class, args);
	}

}
