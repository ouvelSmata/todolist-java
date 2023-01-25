package kimha.todolist;

import kimha.todolist.repository.TodolistRepository;
import kimha.todolist.repository.TodolistRepositoryImpl;
import kimha.todolist.service.TodolistService;
import kimha.todolist.service.TodolistServiceImpl;
import kimha.todolist.view.TodolistView;

/**
 * TodolistAppV2
 */
public class TodolistAppV2 {

  public static void main(String[] args) {
    TodolistRepository todolistRepository = new TodolistRepositoryImpl();
    TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
    TodolistView todolistView = new TodolistView(todolistService);

    todolistView.showTodolist();
  }
}
