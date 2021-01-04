package GalaxyWeather.WeatherPredictor.service;

import GalaxyWeather.WeatherPredictor.dtos.ForecastDTO;
import GalaxyWeather.WeatherPredictor.model.weatherSolver.WeatherPredictor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImp implements WeatherService{


    @Autowired
    private WeatherPredictor weatherPredictor;

    @Override
    public ForecastDTO getForecast(Integer day) {
        String weather = weatherPredictor.calculateForecast(day);

        return weather != null ? ForecastDTO.builder().day(day).description(weather).build() : ForecastDTO.builder().build();
    }
}
