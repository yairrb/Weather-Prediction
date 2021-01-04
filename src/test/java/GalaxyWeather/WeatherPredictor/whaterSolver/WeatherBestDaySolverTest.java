package GalaxyWeather.WeatherPredictor.whaterSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherBestDaySolver;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WeatherBestDaySolverTest {



    private final Planet planetVulcano = new Planet(1,"Ferengi", 1.0 ,true, 500);
    private final Planet planetFerengi = new Planet(2,"Vulcano", 5.0 ,false, 1000);
    private final Planet planetBetasoide = new Planet(3,"Betasoide", 3.0 ,true, 2000);



    public void BestDayHappyTest() {

        WeatherSolver weatherBestDaySolver = new WeatherBestDaySolver(planetFerengi, planetBetasoide, planetVulcano);

        String forecastResult = weatherBestDaySolver.SolveForecast(181);


        assertEquals("optimal pressure and temperature", forecastResult);
    }

    @Test
    public void BestDayCannotBeSolved() {

        WeatherSolver weatherBestDaySolver = new WeatherBestDaySolver(planetFerengi, planetBetasoide, planetVulcano);
        String forecastResult = weatherBestDaySolver.SolveForecast(180);

        assertNull(forecastResult);
        assertEquals(null, forecastResult);
    }
}
