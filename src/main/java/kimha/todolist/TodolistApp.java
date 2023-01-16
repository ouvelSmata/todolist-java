package kimha.todolist;

/**
 * TodolistApp
 */
public class TodolistApp {

  private static String[] model = new String[10];

  public static void main(String[] args) {
    testShowTodolist();
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

  public static void testShowTodolist() {
    model[0] = "Belajar java dasar";
    model[1] = "Belajar membuat todolist";
    showTodolist();
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
