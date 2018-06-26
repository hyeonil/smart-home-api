package kr.pe.nuti.home.api.controller.todo;

import kr.pe.nuti.home.api.domain.todo.TodoItem;
import kr.pe.nuti.home.api.enumeration.todo.TodoState;
import kr.pe.nuti.home.api.exception.todo.IllegalStateChangeException;
import kr.pe.nuti.home.api.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;

  @GetMapping("")
  public void index() {

  }

  @GetMapping("/change/{idx}/{state}")
  public Mono<TodoItem> change(@PathVariable("idx") Long idx, @PathVariable("state") TodoState state) {
    TodoItem todoItem = new TodoItem();
    todoItem.setIdx(idx);
    TodoItem result = null;
    try {
      result = todoService.changeState(todoItem, state);
    } catch (IllegalStateChangeException e) {
      e.printStackTrace();
    }
    return Mono.just(result);
  }

  @Autowired
  public void setTodoService(TodoService todoService) {
    this.todoService = todoService;
  }
}
