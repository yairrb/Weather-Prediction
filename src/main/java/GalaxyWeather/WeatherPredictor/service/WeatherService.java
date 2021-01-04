package GalaxyWeather.WeatherPredictor.service;

import GalaxyWeather.WeatherPredictor.dtos.ForecastDTO;

public interface WeatherService {

    public ForecastDTO getForecast(Integer day);

}
