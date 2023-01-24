package kimha.todolist.view;

import kimha.todolist.service.TodolistService;
import kimha.todolist.util.InputUtil;

/**
 * TodolistView
 */
public class TodolistView {

  private TodolistService service;

  public TodolistView(TodolistService service) {
    this.service = service;
  }

  public void showTodolist() {
    while (true) {
      service.showTodolist();

      System.out.println("Menu:");
      System.out.println("1. Add todolist");
      System.out.println("2. Remove todolist");
      System.out.println("x. Exit");

      String input = InputUtil.input("Choose");

      if (input.equals("1")) {
        addTodolist();
      } else if (input.equals("2")) {
        removeTodolist();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Input could not understood!");
      }
    }
  }

  public void addTodolist() {
    System.out.println("ADD TODOLIST");

    String todo = InputUtil.input("todo (x to exit)");

    if (todo.equals("x")) {
      // Cancel
    } else {
      service.addTodolist(todo);
    }
  }

  public void removeTodolist() {
  }
}
