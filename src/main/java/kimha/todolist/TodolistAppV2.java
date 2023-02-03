package kimha.todolist;

import javax.sql.DataSource;

import kimha.todolist.repository.TodolistRepository;
import kimha.todolist.repository.TodolistRepositoryImpl;
import kimha.todolist.service.TodolistService;
import kimha.todolist.service.TodolistServiceImpl;
import kimha.todolist.util.DatabaseUtil;
import kimha.todolist.view.TodolistView;

/**
 * TodolistAppV2
 */
public class TodolistAppV2 {

  public static void main(String[] args) {
    DataSource dataSource = DatabaseUtil.getDataSource();
    TodolistRepository todolistRepository = new TodolistRepositoryImpl(dataSource);
    TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
    TodolistView todolistView = new TodolistView(todolistService);

    todolistView.showTodolist();
  }
}
