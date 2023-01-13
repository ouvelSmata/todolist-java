package kimha.todolist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.TestInfo;

import kimha.todolist.generator.SimpleNameGenerator;
import lombok.extern.slf4j.Slf4j;

/**
 * AbstractTest
 */
@DisplayNameGeneration(SimpleNameGenerator.class)
@Slf4j
public abstract class AbstractTest {

  @BeforeEach
  void setup(TestInfo info) {
    log.info("{} ✔️", info.getDisplayName());
  }
}
