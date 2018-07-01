package kr.pe.nuti.home.api.service.todo;

import kr.pe.nuti.home.api.core.annotation.LogDetail;
import kr.pe.nuti.home.api.domain.todo.TodoItem;
import kr.pe.nuti.home.api.enumeration.todo.TodoState;
import kr.pe.nuti.home.api.exception.ResourceNotFoundException;
import kr.pe.nuti.home.api.exception.todo.IllegalStateChangeException;
import kr.pe.nuti.home.api.repository.todo.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kr.pe.nuti.home.api.core.util.BooleanUtil.not;

@Service
public class TodoService {

  private TodoItemRepository todoItemRepository;

  @Transactional
  @LogDetail
  public TodoItem changeState(@NonNull TodoItem todo, @NonNull TodoState state) throws IllegalStateChangeException {
    TodoItem savedItem = this.getItem(todo.getIdx());

    final boolean possibleToChangeState = TodoState.isPossibleToChangeState(savedItem.getState(), state);
    if (not(possibleToChangeState)) {
      throw new IllegalStateChangeException();
    }

    savedItem.setState(state);

    return todoItemRepository.save(savedItem);
  }

  public TodoItem getItem(long idx) {
    return todoItemRepository.findById(idx)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Required
  @Autowired
  public void setTodoItemRepository(TodoItemRepository todoItemRepository) {
    this.todoItemRepository = todoItemRepository;
  }
}
