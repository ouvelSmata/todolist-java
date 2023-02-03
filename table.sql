CREATE DATABASE mysql_todolist;

USE mysql_todolist;

SHOW TABLES;

CREATE TABLE todolist (
  id INT NOT NULL AUTO_INCREMENT,
  todo VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
)ENGINE = InnoDB;

DESC todolist;

SELECT * FROM todolist;
