package kr.pe.nuti.home.api.domain.todo;

import kr.pe.nuti.home.api.core.annotation.TrackLog;
import kr.pe.nuti.home.api.enumeration.todo.TodoState;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@TrackLog
public class TodoItem {
  @Id
  @Column(name = "idx")
  private Long idx;

  @Column(name = "state")
  private TodoState state;
}
