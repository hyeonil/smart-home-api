package kr.pe.nuti.home.api.controller.weather;

import kr.pe.nuti.home.api.core.annotation.LogDetail;
import kr.pe.nuti.home.api.domain.weather.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weathers")
public class WeatherController {

  @GetMapping("")
  public Flux<Weather> getWeathers() {
    return null;
  }

  @GetMapping("/{date}")
  public Mono<Weather> getWeather(@PathVariable String date) {
    return null;
  }
}
