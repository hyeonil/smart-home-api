package kr.pe.nuti.home.api.core.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class WebConfiguration {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        int[] arr = {70, 50, 80, 50};
        int[] sorted = IntStream.of(arr).sorted().toArray();
        Arrays.asList(arr).stream().sorted().collect(Collectors.toList());
        registry.addMapping("/**");
      }
    };
  }
}
