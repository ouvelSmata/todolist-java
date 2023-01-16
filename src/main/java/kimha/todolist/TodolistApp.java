package kimha.todolist;

/**
 * TodolistApp
 */
public class TodolistApp {

  private static String[] model = new String[10];

  public static void main(String[] args) {
    System.out.println("Hello World");
  }

  // Show Todolist
  public static void showTodolist() {
    for (int i = 0; i < model.length; i++) {
      String todo = model[i];
      int index = i + 1;

      if (todo != null) {
        System.out.println(index + ". " + todo);
      }
    }
  }

  // Add Todolist
  public static void addTodolist() {
  }

  // Remove Todolist
  public static void removeTodolist() {
  }

  // View show todolist
  public static void viewShowTodolist() {
  }

  // View Add todolist
  public static void viewAddTodolist() {
  }

  // View remove todolist
  public static void viewRemoveTodolist() {
  }
}
