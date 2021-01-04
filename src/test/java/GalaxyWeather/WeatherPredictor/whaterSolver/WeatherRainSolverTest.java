package GalaxyWeather.WeatherPredictor.whaterSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherRainSolver;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WeatherRainSolverTest {


    private Planet planetVulcano = new Planet(1, "Ferengi", 1.0, true, 500);
    private Planet planetFerengi = new Planet(2, "Vulcano", 5.0, false, 1000);
    private Planet planetBetasoide = new Planet(3, "Betasoide", 3.0, true, 2000);


    @Test
    public void isWeatherRainy() {
        WeatherSolver rainSolver = new WeatherRainSolver(planetFerengi, planetBetasoide, planetVulcano);

        String forecast = rainSolver.SolveForecast(80);

        assertEquals("Rain", forecast);

    }

    @Test
    public void isNotWeatherRainy() {
        WeatherSolver rainSolver = new WeatherRainSolver(planetFerengi, planetBetasoide, planetVulcano);

        String forecast = rainSolver.SolveForecast(180);

        assertNull(forecast);
        assertEquals(null, forecast);

    }
}
