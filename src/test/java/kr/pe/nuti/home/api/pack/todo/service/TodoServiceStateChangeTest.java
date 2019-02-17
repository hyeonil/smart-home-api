package kr.pe.nuti.home.api.pack.todo.service;

import kr.pe.nuti.home.api.core.application.Application;
import kr.pe.nuti.home.api.core.application.JpaConfiguration;
import kr.pe.nuti.home.api.core.application.WebConfiguration;
import kr.pe.nuti.home.api.pack.todo.domain.TodoItem;
import kr.pe.nuti.home.api.pack.todo.enumeration.TodoState;
import kr.pe.nuti.home.api.pack.todo.exception.IllegalStateChangeException;
import kr.pe.nuti.home.api.pack.todo.service.TodoService;
import kr.pe.nuti.home.api.pack.todo.repository.TodoItemRepository;
import kr.pe.nuti.home.api.pack.todo.service.impl.TodoServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Title: Todo Item의 상태를 변경한다.
 * User Story:
 * Todo Management System을 사용하는 사용자가
 * Todo Item의 상태관리를 위해서
 * 각각의 Todo Item의 상태를 변경할 수 있다.
 * 상태 변경은 Todo > Doing, Doing > Done,
 * Done > Doing, Doing > Todo로만 할 수 있다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class, WebConfiguration.class, Application.class})
public class TodoServiceStateChangeTest {

  @Mock
  private TodoItemRepository todoItemRepository;

  @Autowired
  @Spy
  @InjectMocks
  private TodoServiceImpl service;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Todo상태를 Doing상태로 변경하면 상태가 변경된다.
   * @throws Exception
   */
  @Test
  public void testStateChangeFromTodoToDoing() throws Exception {
    // given Todo 상태의 Todo Item
    TodoItem savedItem = new TodoItem();
    savedItem.setIdx(1L);
    savedItem.setState(TodoState.TODO);
    TodoItem changedItem = new TodoItem();
    changedItem.setIdx(1L);
    changedItem.setState(TodoState.DOING);
    when(todoItemRepository.save(any(TodoItem.class))).thenReturn(changedItem);
    when(todoItemRepository.findById(1L)).thenReturn(Optional.of(savedItem));

    TodoItem item = new TodoItem();
    item.setIdx(1L);

    // when Todo Item의 상태를 Doing으로 변경한다.
    TodoItem result = service.changeState(item, TodoState.DOING);

    // then Todo Item의 상태가 Doing으로 변경된다.
    Assert.assertThat(result.getState(), is(TodoState.DOING));
    verifyNoMoreInteractions(service);
  }

  /**
   * Todo상태를 Done상태로 변경하면 상태가 변경되지 않고 예외사항이 발생한다.
   * @throws Exception
   */
  @Test(expected = IllegalStateChangeException.class)
  public void testStateChangeFromTodoToDoneThrownException() throws Exception {
    try {
      // given Todo 상태의 Todo Item
      TodoItem savedItem = new TodoItem();
      savedItem.setIdx(1L);
      savedItem.setState(TodoState.TODO);
      TodoItem changedItem = new TodoItem();
      changedItem.setIdx(1L);
      changedItem.setState(TodoState.DOING);
      when(todoItemRepository.findById(any(Long.class))).thenReturn(Optional.of(savedItem));
      when(todoItemRepository.save(any(TodoItem.class))).thenReturn(changedItem);

      TodoItem item = new TodoItem();
      item.setIdx(1L);

      // when Todo Item의 상태를 Done으로 변경한다.
      service.changeState(item, TodoState.DONE);

      // then Todo Item의 상태가 변경되지 않고 예외사항이 발생한다.
    } catch (Exception e) {
      verifyNoMoreInteractions(service);
      throw e;
    }
  }
}
