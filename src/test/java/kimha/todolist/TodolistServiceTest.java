package kimha.todolist;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import kimha.todolist.entity.Todolist;
import kimha.todolist.repository.TodolistRepositoryImpl;
import kimha.todolist.service.TodolistService;
import kimha.todolist.service.TodolistServiceImpl;

/**
 * TodolistServiceTest
 */
public class TodolistServiceTest extends AbstractTest {

  @Tag("testShowTodolist")
  @Test
  void testShowTodolist() {
    TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
    repository.data[0] = new Todolist("Satu");
    repository.data[1] = new Todolist("Dua");
    repository.data[2] = new Todolist("Tiga");

    TodolistService service = new TodolistServiceImpl(repository);
    service.showTodolist();
  }
}
