package kimha.todolist.util;

import java.util.Scanner;

/**
 * InputUtil
 */
public class InputUtil {

  private static Scanner scanner = new Scanner(System.in);

  public static String input(String info) {
    System.out.print(info + ": ");
    String data = scanner.nextLine();
    return data;
  }
}
