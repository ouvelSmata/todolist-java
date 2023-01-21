package kimha.todolist.repository;

import kimha.todolist.entity.Todolist;

/**
 * TodolistRepository
 */
public interface TodolistRepository {

  Todolist[] getAll();

  void add(Todolist todolist);

  void remove(Integer number);
}
