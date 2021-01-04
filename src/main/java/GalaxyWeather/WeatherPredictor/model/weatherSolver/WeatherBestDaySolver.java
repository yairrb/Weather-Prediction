package GalaxyWeather.WeatherPredictor.model.weatherSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class WeatherBestDaySolver extends SolarSystemWeatherSolver implements WeatherSolver {



    public WeatherBestDaySolver(Planet planet1, Planet planet2, Planet planet3) {
        super(planet1, planet2, planet3);
    }


    @Override
    public String SolveForecast(Integer day) {
        double  vectorAB = ( getPoint(this.getPlanet2(),day).getY() - getPoint(this.getPlanet1(),day).getY() ) / (getPoint(getPlanet2(),day).getX() - getPoint(getPlanet1(),day).getX());

        double  vectorBC = ( getPoint(getPlanet3(),day).getY() - getPoint(getPlanet2(),day).getY() ) / (getPoint(getPlanet3(),day).getX() - getPoint(getPlanet2(),day).getX());

        double vectorWithTheSun = (getPoint(getPlanet1(),day).getY() ) / (getPoint(getPlanet1(),day).getX());

        return vectorAB == vectorBC && vectorWithTheSun != vectorAB ? "optimal pressure and temperature" : null;
    }
}
