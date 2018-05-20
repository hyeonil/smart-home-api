package kr.pe.nuti.home.api.repository.todo;

import kr.pe.nuti.home.api.domain.todo.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
