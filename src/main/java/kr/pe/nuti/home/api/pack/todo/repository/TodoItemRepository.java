package kr.pe.nuti.home.api.pack.todo.repository;

import kr.pe.nuti.home.api.pack.todo.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
