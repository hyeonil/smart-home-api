package kr.pe.nuti.home.api.handler.route;

import kr.pe.nuti.home.api.handler.weather.WeatherHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WeatherRouter {

  /*
  @Bean
  public RouterFunction<ServerResponse> weatherRouterFunction(WeatherHandler weatherHandler) {
    return route(GET("/weathers").and(accept(MediaType.APPLICATION_JSON_UTF8)), weatherHandler::getWeathers)
        .andRoute(GET("/weathers/{date}").and(accept(MediaType.APPLICATION_JSON_UTF8)), weatherHandler::getWeather);
  }
  */
}
