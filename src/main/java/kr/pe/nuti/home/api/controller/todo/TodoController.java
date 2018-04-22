package kr.pe.nuti.home.api.controller.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

  @GetMapping("")
  public void index() {

  }
}
