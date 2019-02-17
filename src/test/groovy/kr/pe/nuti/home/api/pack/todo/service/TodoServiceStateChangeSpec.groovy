package kr.pe.nuti.home.api.pack.todo.service

import kr.pe.nuti.home.api.pack.todo.domain.TodoItem
import kr.pe.nuti.home.api.pack.todo.enumeration.TodoState
import kr.pe.nuti.home.api.pack.todo.exception.IllegalStateChangeException
import kr.pe.nuti.home.api.pack.todo.service.TodoService
import kr.pe.nuti.home.api.pack.todo.repository.TodoItemRepository
import kr.pe.nuti.home.api.pack.todo.service.impl.TodoServiceImpl
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.See
import spock.lang.Specification
import spock.lang.Title

@Title("Todo Item의 상태를 변경한다.")
@Narrative("""
Todo Management System을 사용하는 사용자가
Todo Item의 상태관리를 위해서
각각의 Todo Item의 상태를 변경할 수 있다.
상태 변경은 Todo > Doing, Doing > Done,
Done > Doing, Doing > Todo로만 할 수 있다.
""")
class TodoServiceStateChangeSpec extends Specification {

  TodoService service
  def todoItemRepository

  def setup() {
    todoItemRepository = Mock(TodoItemRepository)
    service = Spy(TodoServiceImpl)
    service.todoItemRepository = todoItemRepository
  }

  @See(["https://github.com/hyeonil/smart-home-api/issues/6"])
  @Issue("#6")
  def "Todo상태를 Doing상태로 변경하면 상태가 변경된다."() {
    given: "Todo 상태의 Todo Item"
    TodoItem savedItem = new TodoItem([idx: 1L, state: TodoState.TODO])
    TodoItem changedItem = new TodoItem([idx: 1L, state: TodoState.DOING])
    todoItemRepository.findById(_) >> Optional.of(savedItem)
    todoItemRepository.save(_) >>  changedItem

    TodoItem item = new TodoItem([idx: 1L])

    when: "Todo Item의 상태를 Doing으로 변경한다."
    def result = service.changeState(item, TodoState.DOING)

    then: "Todo Item의 상태가 Doing으로 변경된다."
    1 * service.getItem(_)
    result.state == TodoState.DOING
  }

  @See(["https://github.com/hyeonil/smart-home-api/issues/6"])
  @Issue("#6")
  def "Todo상태를 Done상태로 변경하면 상태가 변경되지 않고 예외사항이 발생한다."() {
    given: "Todo 상태의 Todo Item"
    TodoItem savedItem = new TodoItem([idx: 1L, state: TodoState.TODO])
    todoItemRepository.findById(_) >> Optional.of(savedItem)

    TodoItem item = new TodoItem([idx: 1L])

    when: "Todo Item의 상태를 Done으로 변경한다."
    service.changeState(item, TodoState.DONE)

    then: "Todo Item의 상태가 변경되지 않고 예외사항이 발생한다."
    1 * service.getItem(_)
    thrown(IllegalStateChangeException)
  }
}

