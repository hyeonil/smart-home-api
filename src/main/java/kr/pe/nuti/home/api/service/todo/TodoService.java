package kr.pe.nuti.home.api.service.todo;

import kr.pe.nuti.home.api.domain.todo.TodoItem;
import kr.pe.nuti.home.api.enumeration.todo.TodoState;
import kr.pe.nuti.home.api.exception.ResourceNotFoundException;
import kr.pe.nuti.home.api.exception.todo.IllegalStateChangeException;
import kr.pe.nuti.home.api.repository.todo.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public class TodoService {

  private TodoItemRepository todoItemRepository;

  @Transactional
  public TodoItem changeState(@NonNull TodoItem todo, @NonNull TodoState state) throws IllegalStateChangeException {
    TodoItem savedItem = todoItemRepository.findById(todo.getIdx())
        .orElseThrow(ResourceNotFoundException::new);

    final boolean possibleToChangeState = TodoState.isPossibleToChangeState(savedItem.getState(), state);
    if (!possibleToChangeState) {
      throw new IllegalStateChangeException();
    }

    savedItem.setState(state);

    return todoItemRepository.save(savedItem);
  }

  @Required
  @Autowired
  public void setTodoItemRepository(TodoItemRepository todoItemRepository) {
    this.todoItemRepository = todoItemRepository;
  }
}
