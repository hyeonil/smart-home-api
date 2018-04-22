package kr.pe.nuti.home.api.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(
    basePackages = {
        "kr.pe.nuti.home.api"
    }
)
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication application = new SpringApplication(Application.class);
    application.setWebApplicationType(WebApplicationType.REACTIVE);
    application.run(args);
  }
}
