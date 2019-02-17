package kr.pe.nuti.home.api.pack.todo.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TodoState {
  TODO,
  DOING,
  DONE;

  public static boolean isPossibleToChangeState(TodoState from, TodoState to) {
    List<TodoState> possibleChangeStateList = new ArrayList<>();
    switch(from) {
      case TODO:
        possibleChangeStateList.add(DOING);
        break;
      case DOING:
        possibleChangeStateList.addAll(Arrays.asList(TODO, DONE));
        break;
      case DONE:
        possibleChangeStateList.add(DOING);
        break;
      default:
    }

    return possibleChangeStateList.contains(to);
  }
}
