package kr.pe.nuti.home.api.handler.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/*@Component*/
public class WeatherHandler {
  public Mono<ServerResponse> getWeathers(ServerRequest request) {
    return null;
  }

  public Mono<ServerResponse> getWeather(ServerRequest request) {
    return null;
  }
}
