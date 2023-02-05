package kimha.todolist.entity;

/**
 * Todolist
 */
public class Todolist {

  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private String todo;

  public Todolist(String todo) {
    this.todo = todo;
  }

  public Todolist() {
  }

  public String getTodo() {
    return todo;
  }

  public void setTodo(String todo) {
    this.todo = todo;
  }
}
