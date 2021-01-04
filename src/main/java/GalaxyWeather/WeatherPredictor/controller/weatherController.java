package GalaxyWeather.WeatherPredictor.controller;


import GalaxyWeather.WeatherPredictor.dtos.ForecastDTO;
import GalaxyWeather.WeatherPredictor.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
public class weatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/weather/{day}")
    public ResponseEntity<ForecastDTO> getWeatherPerDay(@PathVariable(value = "day") Integer day) {
        ForecastDTO responseForecast = service.getForecast(day);

        return ResponseEntity.ok(responseForecast);
    }

    @GetMapping("/angle/")
    public String getPositiion(
            @PathParam("day") Integer day,
            @PathParam("degrees") Integer degrees,
            @PathParam("distance") Integer distance ) {
        String message = "";
        double angle = Math.toRadians( ((degrees * day * 1) % 360) );

        double positionX = distance * Math.cos(angle);

        double positionY = distance * Math.sin(angle);

        message = "the position is: "+ positionX + " , "+positionY;

        return message;
    }



}
