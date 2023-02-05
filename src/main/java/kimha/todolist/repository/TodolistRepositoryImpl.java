package kimha.todolist.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kimha.todolist.entity.Todolist;

/**
 * TodolistRepositoryImpl
 */
public class TodolistRepositoryImpl implements TodolistRepository {

  // private Todolist[] data = new Todolist[10];

  private DataSource dataSource;

  public TodolistRepositoryImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Todolist[] getAll() {
    // return data;
    String sql = "SELECT id, todo FROM todolist";

    try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);) {
      List<Todolist> todolists = new ArrayList<>();

      while (resultSet.next()) {
        Todolist todolist = new Todolist();
        todolist.setId(resultSet.getInt("id"));
        todolist.setTodo(resultSet.getString("todo"));

        todolists.add(todolist);
      }

      return todolists.toArray(new Todolist[] {});
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // private boolean isFull() {
  // boolean isFull = true;

  // for (int i = 0; i < data.length; i++) {
  // if (data[i] != null) {
  // isFull = false;
  // }
  // }

  // return isFull;
  // }

  // private void resizeIfFull() {
  // if (isFull()) {
  // Todolist[] temp = data;
  // data = new Todolist[data.length * 2];

  // for (int i = 0; i < temp.length; i++) {
  // data[i] = temp[i];
  // }
  // }
  // }

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

  public boolean isExist(Integer number) {
    String sql = "SELECT * FROM todolist WHERE id = ?";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);) {
      statement.setInt(1, number);

      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          return true;
        } else {
          return false;
        }
      }
    } catch (SQLException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  public boolean remove(Integer number) {
    // if ((number - 1) >= data.length) {
    // return false;
    // } else if (data[number - 1] == null) {
    // return false;
    // } else {
    // for (int i = (number - 1); i < data.length; i++) {
    // if (i == data.length - 1) {
    // data[i] = null;
    // } else {
    // data[i] = data[i + 1];
    // }
    // }
    // return true;
    // }
    String sql = "DELETE FROM todolist WHERE id = ?";

    if (isExist(number)) {
      try (Connection connection = dataSource.getConnection();
          PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, number);
        statement.executeUpdate();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return true;
    } else {
      return false;
    }
  }

}
