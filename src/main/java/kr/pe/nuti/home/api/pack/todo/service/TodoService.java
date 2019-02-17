package kr.pe.nuti.home.api.pack.todo.service;

import kr.pe.nuti.home.api.pack.todo.domain.TodoItem;
import kr.pe.nuti.home.api.pack.todo.enumeration.TodoState;
import kr.pe.nuti.home.api.pack.todo.exception.CannotArchiveException;
import kr.pe.nuti.home.api.pack.todo.exception.IllegalStateChangeException;
import org.springframework.lang.NonNull;

public interface TodoService {
  TodoItem save(@NonNull TodoItem todoItem);
  TodoItem modify(@NonNull TodoItem todoItem);
  TodoItem delete(@NonNull TodoItem todoItem);
  TodoItem changeState(@NonNull TodoItem todo, @NonNull TodoState state) throws IllegalStateChangeException;
  TodoItem archive(@NonNull TodoItem todoItem) throws CannotArchiveException;
  TodoItem search();
  TodoItem getItem(long idx);
}
