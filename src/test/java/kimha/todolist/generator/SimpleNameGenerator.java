package kimha.todolist.generator;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGenerator;

/**
 * SimpleNameGenerator
 */
public class SimpleNameGenerator implements DisplayNameGenerator {

  @Override
  public String generateDisplayNameForClass(Class<?> arg0) {
    return arg0.getSimpleName();
  }

  @Override
  public String generateDisplayNameForMethod(Class<?> arg0, Method arg1) {
    return "Test " + arg0.getSimpleName() + "." + arg1.getName();
  }

  @Override
  public String generateDisplayNameForNestedClass(Class<?> arg0) {
    return "Test " + arg0.getSimpleName();
  }

}
