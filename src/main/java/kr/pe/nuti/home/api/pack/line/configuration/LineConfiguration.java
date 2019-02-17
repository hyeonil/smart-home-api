package kr.pe.nuti.home.api.pack.line.configuration;

import kr.pe.nuti.home.api.pack.line.LineEnvironmentVariables;
import kr.pe.nuti.home.api.pack.line.component.LineMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LineConfiguration {

  @Bean
  public LineMessageSender lineMessageSender() {
    String token = System.getProperty(LineEnvironmentVariables.AUTH_TOKEN);
    return new LineMessageSender(token);
  }
}
