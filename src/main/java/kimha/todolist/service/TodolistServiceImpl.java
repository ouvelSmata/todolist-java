package kimha.todolist.service;

import kimha.todolist.entity.Todolist;
import kimha.todolist.repository.TodolistRepository;

/**
 * TodolistServiceImpl
 */
public class TodolistServiceImpl implements TodolistService {

  private TodolistRepository repository;

  public TodolistServiceImpl(TodolistRepository repository) {
    this.repository = repository;
  }

  @Override
  public void showTodolist() {
    Todolist[] model = repository.getAll();

    System.out.println("TODOLIST");

    for (int i = 0; i < model.length; i++) {
      Todolist todo = model[i];
      int number = i + 1;

      if (todo != null) {
        System.out.println(number + ". " + todo.getTodo());
      }
    }
  }

  @Override
  public void addTodolist(String todo) {
    Todolist todolist = new Todolist(todo);

    repository.add(todolist);

    System.out.println("Sukses menambah todo: " + todo);
  }

  @Override
  public void removeTodolist(Integer number) {
    boolean isSuccess = repository.remove(number);

    if (isSuccess) {
      System.out.println("Successfully removed todo: " + number);
    } else {
      System.out.println("Failure to remove todo: " + number);
    }
  }

}
