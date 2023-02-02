package kimha.todolist.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import kimha.todolist.entity.Todolist;

/**
 * TodolistRepositoryImpl
 */
public class TodolistRepositoryImpl implements TodolistRepository {

  private Todolist[] data = new Todolist[10];

  private DataSource dataSource;

  public TodolistRepositoryImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Todolist[] getAll() {
    return data;
  }

  private boolean isFull() {
    boolean isFull = true;

    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        isFull = false;
      }
    }

    return isFull;
  }

  private void resizeIfFull() {
    if (isFull()) {
      Todolist[] temp = data;
      data = new Todolist[data.length * 2];

      for (int i = 0; i < temp.length; i++) {
        data[i] = temp[i];
      }
    }
  }

  @Override
  public void add(Todolist todolist) {
    // resizeIfFull();

    // for (int i = 0; i < data.length; i++) {
    // if (data[i] == null) {
    // data[i] = todolist;
    // break;
    // }
    // }

    String sql = "INSERT INTO todolist(todo) VALUES(?)";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);) {
      statement.setString(1, todolist.getTodo());
      statement.executeUpdate();
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean remove(Integer number) {
    if ((number - 1) >= data.length) {
      return false;
    } else if (data[number - 1] == null) {
      return false;
    } else {
      for (int i = (number - 1); i < data.length; i++) {
        if (i == data.length - 1) {
          data[i] = null;
        } else {
          data[i] = data[i + 1];
        }
      }
      return true;
    }
  }

}
