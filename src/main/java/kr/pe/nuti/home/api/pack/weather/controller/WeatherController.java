package kr.pe.nuti.home.api.pack.weather.controller;

import kr.pe.nuti.home.api.pack.weather.domain.Weather;
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
