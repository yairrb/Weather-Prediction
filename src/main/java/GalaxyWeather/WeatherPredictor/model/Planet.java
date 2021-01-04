package GalaxyWeather.WeatherPredictor.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class Planet {

    @Id
    Integer id;

    String name;

    Double degreesPerDay;

    Boolean isClockWise;

    Integer distanceFromSun;

}
