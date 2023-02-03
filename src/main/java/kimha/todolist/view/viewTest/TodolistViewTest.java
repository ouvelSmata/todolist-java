package kimha.todolist.view.viewTest;

import com.zaxxer.hikari.HikariDataSource;

import kimha.todolist.repository.TodolistRepository;
import kimha.todolist.repository.TodolistRepositoryImpl;
import kimha.todolist.service.TodolistService;
import kimha.todolist.service.TodolistServiceImpl;
import kimha.todolist.util.DatabaseUtil;
import kimha.todolist.view.TodolistView;

/**
 * TodolistViewTest
 */
public class TodolistViewTest {

  private static HikariDataSource dataSource;

  // @BeforeEach
  void setUp() {
    dataSource = DatabaseUtil.getDataSource();
  }

  // @AfterEach
  void tearDown() {
    dataSource.close();
  }

  public static void main(String[] args) {
    testViewRemoveTodolist();
  }

  static void testViewShowTodolist() {
    TodolistRepository repository = new TodolistRepositoryImpl(dataSource);
    TodolistService service = new TodolistServiceImpl(repository);
    TodolistView view = new TodolistView(service);

    service.addTodolist("Satu");
    service.addTodolist("Dua");
    service.addTodolist("Tiga");

    view.showTodolist();
  }

  static void testViewAddTodolist() {
    TodolistRepository repository = new TodolistRepositoryImpl(dataSource);
    TodolistService service = new TodolistServiceImpl(repository);
    TodolistView view = new TodolistView(service);

    view.addTodolist();
    service.showTodolist();

    view.addTodolist();
    service.showTodolist();
  }

  static void testViewRemoveTodolist() {
    TodolistRepository repository = new TodolistRepositoryImpl(dataSource);
    TodolistService service = new TodolistServiceImpl(repository);
    TodolistView view = new TodolistView(service);

    service.addTodolist("Satu");
    service.addTodolist("Dua");
    service.addTodolist("Tiga");

    service.showTodolist();
    view.removeTodolist();
    service.showTodolist();
  }
}
