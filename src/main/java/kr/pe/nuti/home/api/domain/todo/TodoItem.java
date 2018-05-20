package kr.pe.nuti.home.api.domain.todo;

import kr.pe.nuti.home.api.enumeration.todo.TodoState;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class TodoItem {
  private Long idx;
  private TodoState state;
}
