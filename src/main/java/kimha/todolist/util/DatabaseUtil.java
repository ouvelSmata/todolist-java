package kimha.todolist.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * DatabaseUtil
 */
public class DatabaseUtil {

  private static HikariDataSource dataSource;

  static {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    config.setUsername("kimha");
    config.setPassword("kimha006");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/mysql_todolist");

    config.setMaximumPoolSize(10);
    config.setMinimumIdle(5);
    config.setIdleTimeout(60000);
    config.setMaxLifetime(60 * 60 * 1000);

    dataSource = new HikariDataSource(config);
  }

  public static HikariDataSource getDataSource() {
    return dataSource;
  }
}
