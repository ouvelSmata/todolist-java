package kimha.todolist;

/**
 * TodolistApp
 */
public class TodolistApp {

  private static String[] model = new String[10];

  public static void main(String[] args) {
    testAddTodolist();
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
  public static void addTodolist(String todo) {
    boolean isFull = true;

    // Checking if model is full or not
    for (int i = 0; i < model.length; i++) {
      if (model[i] == null) {
        isFull = false;
        break;
      }
    }

    // If full, resize model twice of the length
    if (isFull) {
      String[] temp = model;
      model = new String[model.length * 2];

      for (int i = 0; i < temp.length; i++) {
        model[i] = temp[i];
      }
    }

    // Add todo to model
    for (int i = 0; i < model.length; i++) {
      if (model[i] == null) {
        model[i] = todo;
        break;
      }
    }
  }

  public static void testAddTodolist() {
    for (int i = 0; i < 25; i++) {
      addTodolist("Todolist ke-" + i);
    }

    showTodolist();
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
