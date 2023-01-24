package kimha.todolist;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import kimha.todolist.entity.Todolist;
import kimha.todolist.repository.TodolistRepository;
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
    TodolistRepository repository = Mockito.mock(TodolistRepository.class);
    Mockito.when(repository.getAll())
        .thenReturn(new Todolist[] { new Todolist("Satu"), new Todolist("Dua"), new Todolist("Tiga") });

    TodolistService service = new TodolistServiceImpl(repository);
    service.showTodolist();
  }

  @Tag("testAddTodolist")
  @Test
  void testAddTodolist() {
    TodolistRepository repository = new TodolistRepositoryImpl();
    TodolistService service = new TodolistServiceImpl(repository);

    // service.addTodolist("Satu");
    // service.addTodolist("Dua");
    // service.addTodolist("Tiga");

    for (int i = 0; i < 25; i++) {
      service.addTodolist("Todo ke-" + i);
    }

    service.showTodolist();
  }

  @Tag("testRemoveTodolist")
  @Test
  void testRemoveTodolist() {
    TodolistRepository repository = new TodolistRepositoryImpl();
    TodolistService service = new TodolistServiceImpl(repository);

    service.addTodolist("Satu");
    service.addTodolist("Dua");
    service.addTodolist("Tiga");
    service.showTodolist();

    service.removeTodolist(5);
    service.showTodolist();

    service.removeTodolist(15);
    service.showTodolist();

    service.removeTodolist(2);
    service.showTodolist();
  }
}
