package kr.pe.nuti.home.api.controller.monitoring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {

  @GetMapping("")
  public String index() {
    return "";
  }

  @RequestMapping(value = "/check", method = RequestMethod.OPTIONS)
  @ResponseStatus(HttpStatus.OK)
  public void check() {

  }
}
