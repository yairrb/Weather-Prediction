package GalaxyWeather.WeatherPredictor.model.weatherSolver;

import GalaxyWeather.WeatherPredictor.model.Planet;
import lombok.*;

import java.awt.geom.Point2D;

@Data
@ToString
@EqualsAndHashCode
public class WeatherRainSolver extends SolarSystemWeatherSolver implements WeatherSolver {



    public WeatherRainSolver(Planet planet1, Planet planet2, Planet planet3) {
        super(planet1, planet2, planet3);
    }

    @Override
    public String SolveForecast(Integer day) {

        Point2D theSun = new Point2D.Double(0,0);
        boolean isSunIntoTriangle = PointInTriangle(theSun, getPoint(getPlanet1(), day) ,getPoint(getPlanet2(), day), getPoint(getPlanet3(), day) );

        return isSunIntoTriangle ? "Rain" : null;
    }

    double sign(Point2D p1, Point2D p2, Point2D p3) {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    boolean PointInTriangle(Point2D pt, Point2D v1, Point2D v2, Point2D v3) {
        boolean b1, b2, b3;
        b1 = sign(pt, v1, v2) < 0.0f;
        b2 = sign(pt, v2, v3) < 0.0f;
        b3 = sign(pt, v3, v1) < 0.0f;
        return ((b1 == b2) && (b2 == b3));
    }
}
