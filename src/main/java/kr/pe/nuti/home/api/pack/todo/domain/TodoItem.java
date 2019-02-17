package kr.pe.nuti.home.api.pack.todo.domain;

import kr.pe.nuti.home.api.core.annotation.TrackLog;
import kr.pe.nuti.home.api.pack.todo.enumeration.TodoState;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "todo_item")
@TrackLog
public class TodoItem {
  @Id
  @Column(name = "idx")
  private Long idx;

  private String title;

  private String content;

  @Column(name = "state")
  private TodoState state;
}
