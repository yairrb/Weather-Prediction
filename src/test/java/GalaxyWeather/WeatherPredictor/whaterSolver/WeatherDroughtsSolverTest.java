package GalaxyWeather.WeatherPredictor.whaterSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherDroughtsSolver;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WeatherDroughtsSolverTest {



    private final Planet planetVulcano = new Planet(1,"Ferengi", 1.0 ,true, 500);
    private final Planet planetFerengi = new Planet(2,"Vulcano", 5.0 ,false, 1000);
    private final Planet planetBetasoide = new Planet(3,"Betasoide", 3.0 ,true, 2000);


    @Test
    public void DrougthDayAtDay0() {

        WeatherDroughtsSolver weatherDrougthSolver = new WeatherDroughtsSolver(planetFerengi, planetBetasoide, planetVulcano);
        String forecastResult = weatherDrougthSolver.SolveForecast(0);

        assertEquals("Drougth", forecastResult);
    }

    @Test
    public void DrougthWithOutSolution() {

        WeatherSolver weatherDrougthSolver = new WeatherDroughtsSolver(planetFerengi, planetBetasoide, planetVulcano);
        String forecastResult = weatherDrougthSolver.SolveForecast(2);

        assertNull(forecastResult);
        assertEquals(null, forecastResult);
    }
}
