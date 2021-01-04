package GalaxyWeather.WeatherPredictor.model.weatherSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import lombok.*;

import java.awt.geom.Point2D;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public abstract class SolarSystemWeatherSolver {


    private Planet planet1;
    private Planet planet2;
    private Planet planet3;


    public Point2D getPoint(Planet planet, Integer day){
        double angle = 0.0;

        if ( planet.getIsClockWise() ){

             angle = Math.toRadians( ((planet.getDegreesPerDay() * day * -1) % 360) );
        }else {
             angle = Math.toRadians( ((planet.getDegreesPerDay() * day * 1) % 360) );

        }

        double positionX = planet.getDistanceFromSun() * Math.cos(angle);

        double positionY = planet.getDistanceFromSun() * Math.sin(angle);

        return new Point2D.Double(positionX,positionY);
    }


}
