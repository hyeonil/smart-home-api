package kr.pe.nuti.home.api.pack.todo.service.impl;

import kr.pe.nuti.home.api.pack.todo.domain.TodoItem;
import kr.pe.nuti.home.api.pack.todo.enumeration.TodoState;
import kr.pe.nuti.home.api.exception.ResourceNotFoundException;
import kr.pe.nuti.home.api.pack.todo.exception.CannotArchiveException;
import kr.pe.nuti.home.api.pack.todo.exception.IllegalStateChangeException;
import kr.pe.nuti.home.api.pack.todo.service.TodoService;
import kr.pe.nuti.home.api.pack.todo.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kr.pe.nuti.home.api.core.util.BooleanUtil.not;

@Service
public class TodoServiceImpl implements TodoService {
  private TodoItemRepository todoItemRepository;

  @Transactional
  @Override
  public TodoItem save(@NonNull TodoItem todo) {
    return null;
  }

  @Transactional
  @Override
  public TodoItem modify(TodoItem todoItem) {
    return null;
  }

  @Transactional
  @Override
  public TodoItem delete(TodoItem todoItem) {
    return null;
  }

  @Transactional
  @Override
  public TodoItem changeState(@NonNull TodoItem todo, @NonNull TodoState state) throws IllegalStateChangeException {
    TodoItem savedItem = this.getItem(todo.getIdx());

    final boolean possibleToChangeState = TodoState.isPossibleToChangeState(savedItem.getState(), state);
    if (not(possibleToChangeState)) {
      throw new IllegalStateChangeException();
    }

    savedItem.setState(state);

    return todoItemRepository.save(savedItem);
  }

  @Transactional
  @Override
  public TodoItem archive(TodoItem todoItem) throws CannotArchiveException {
    return null;
  }

  @Override
  public TodoItem search() {
    return null;
  }

  @Override
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
