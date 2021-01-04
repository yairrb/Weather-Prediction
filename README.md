#Examen Sistema Solar

## consigna

En una galaxia lejana, existen tres civilizaciones. Vulcanos, Ferengis y Betasoides. Cada
civilización vive en paz en su respectivo planeta.

Realizar un programa informático para poder predecir en los próximos 10 años:

1. ¿Cuántos períodos de sequía habrá?
2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?

Bonus:
Para poder utilizar el sistema como un servicio a las otras civilizaciones, los Vulcanos requieren
tener una base de datos con las condiciones meteorológicas de todos los días y brindar una API
REST de consulta sobre las condiciones de un día en particular.
1) Generar un modelo de datos con las condiciones de todos los días hasta 10 años en adelante
utilizando un job para calcularlas.
2) Generar una API REST la cual devuelve en formato JSON la condición climática del día
consultado.
3) Hostear el modelo de datos y la API REST en un cloud computing libre (como APP Engine o
Cloudfoudry) y enviar la URL para consulta:
Ej: GET → http://….../clima?dia=566 → Respuesta: {“dia”:566, “clima”:”lluvia”}


### Premisas:
* El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido
horario. Su distancia con respecto al sol es de 500Km.
* El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido
horario. Su distancia con respecto al sol es de 2000Km.
* El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido
anti horario, su distancia con respecto al sol es de 1000Km.
* Todas las órbitas son circulares.

## Implementacion

### Base de datos
  La base de datos utilizada hasta el momento es una base H2 la cual existira mientras viva nuestra aplicacion.
  El file data.sql Carga los valores necesarios de los planetas.
  
  De forma local se puede acceder en /h2-console/
  
### Sobre la aplicacion

  La aplicacion Spring se encuentra deployada en heroku. Las consultas se pueden realizar en la siguiente url
  ```
  https://weather-prediction-ml.herokuapp.com/weather/**{day}**
  
  ```
  ejemplo:
  https://weather-prediction-ml.herokuapp.com/weather/80
  
### Consideraciones:
  * Aun no esta implementado el job para cargar en la base todos los dias y sus periodos, debido a que no he decidido que calendario deberia utilizar. En cada planeta los años
  transcurren de formas distintas debido a la velocidad con la que orbitan el sol.
  * Los dias donde no se puede determinar el clima segun las premisas, los considero como * dias regulares *
  
  
