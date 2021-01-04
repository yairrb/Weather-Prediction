package GalaxyWeather.WeatherPredictor.repository;

import GalaxyWeather.WeatherPredictor.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {
}
