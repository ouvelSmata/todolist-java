package kimha.todolist;

/**
 * TodolistApp
 */
public class TodolistApp {

  private static String[] model = new String[10];

  private static java.util.Scanner scanner = new java.util.Scanner(System.in);

  public static void main(String[] args) {
    testViewAddTodolist();
  }

  // Show Todolist
  public static void showTodolist() {
    System.out.println("TODOLIST");
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

  public static String input(String info) {
    System.out.print(info + ": ");
    String data = scanner.nextLine();
    return data;
  }

  public static void testInput() {
    String name = input("name");
    System.out.println("Hello " + name);

    String channel = input("channel");
    System.out.println(channel);
  }

  // View show todolist
  public static void viewShowTodolist() {
    while (true) {
      showTodolist();

      System.out.println("Menu:");
      System.out.println("1. Add todolist");
      System.out.println("2. Remove todolist");
      System.out.println("x. Exit");

      String input = input("Choose");

      if (input.equals("1")) {
        viewAddTodolist();
      } else if (input.equals("2")) {
        viewRemoveTodolist();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Input could not understood!");
      }
    }
  }

  public static void testViewShowTodolist() {
    addTodolist("Satu");
    addTodolist("Dua");
    addTodolist("Tiga");
    addTodolist("Empat");
    addTodolist("Lima");
    viewShowTodolist();
  }

  // View Add todolist
  public static void viewAddTodolist() {
    System.out.println("MENAMBAH TODOLIST");

    String todo = input("todo (x untuk keluar)");

    if (todo.equals("x")) {
      // Cancel
    } else {
      addTodolist(todo);
    }
  }

  public static void testViewAddTodolist() {
    addTodolist("Satu");
    addTodolist("Dua");

    viewAddTodolist();
    showTodolist();
  }

  // View remove todolist
  public static void viewRemoveTodolist() {
  }
}
