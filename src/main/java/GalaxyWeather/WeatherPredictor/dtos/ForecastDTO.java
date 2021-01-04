package GalaxyWeather.WeatherPredictor.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ForecastDTO {

    String description;

    Integer day;

}
