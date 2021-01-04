package GalaxyWeather.WeatherPredictor.model.weatherSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import GalaxyWeather.WeatherPredictor.repository.PlanetRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
@Data
@ToString
@EqualsAndHashCode
@Component
public class WeatherPredictor {

    private List<WeatherSolver> weatherSolvers;

    @Autowired
    private PlanetRepository planetRepository;

    @PostConstruct
    public void WeatherPredictor() {
        List<Planet> planets = planetRepository.findAll();
        weatherSolvers = Arrays.asList(
                new WeatherDroughtsSolver(planets.get(0),planets.get(1),planets.get(2)),
                new WeatherBestDaySolver(planets.get(0),planets.get(1),planets.get(2)),
                new WeatherRainSolver(planets.get(0),planets.get(1),planets.get(2)));

    }


    public String calculateForecast(Integer day){
        for ( WeatherSolver solver : weatherSolvers) {
            String weather = solver.SolveForecast(day);
            if (weather != null) {
                return weather;
            }
        }
        return "regular day";
    }

}
