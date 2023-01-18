package kimha.todolist;

/**
 * TodolistApp
 */
public class TodolistApp {

  private static String[] model = new String[10];

  public static void main(String[] args) {
    testRemoveTodolist();
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
  public static boolean removeTodolist(Integer number) {
    if ((number - 1) >= model.length) {
      return false;
    } else if (model[number - 1] == null) {
      return false;
    } else {
      for (int i = (number - 1); i < model.length; i++) {
        if (i == model.length - 1) {
          model[i] = null;
        } else {
          model[i] = model[i + 1];
        }
      }
      return true;
    }
  }

  public static void testRemoveTodolist() {
    addTodolist("Satu");
    addTodolist("Dua");
    addTodolist("Tiga");
    addTodolist("Empat");
    addTodolist("Lima");

    boolean result = removeTodolist(15);
    System.out.println(result);

    result = removeTodolist(7);
    System.out.println(result);

    result = removeTodolist(2);
    System.out.println(result);

    showTodolist();
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
