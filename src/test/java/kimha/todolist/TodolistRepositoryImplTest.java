package kimha.todolist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import kimha.todolist.entity.Todolist;
import kimha.todolist.repository.TodolistRepository;
import kimha.todolist.repository.TodolistRepositoryImpl;
import kimha.todolist.util.DatabaseUtil;

/**
 * TodolistRepositoryImplTest
 */
public class TodolistRepositoryImplTest {

  private HikariDataSource dataSource;

  private TodolistRepository repository;

  @BeforeEach
  void setUp() {
    dataSource = DatabaseUtil.getDataSource();
    repository = new TodolistRepositoryImpl(dataSource);
  }

  @AfterEach
  void tearDown() {
    dataSource.close();
  }

  @Tag("testRepositoryAdd")
  @Test
  void testRepositoryAdd() {
    Todolist todolist = new Todolist();
    todolist.setTodo("Otong");

    repository.add(todolist);
  }
}
