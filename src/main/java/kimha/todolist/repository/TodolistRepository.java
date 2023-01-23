package kimha.todolist.repository;

import kimha.todolist.entity.Todolist;

/**
 * TodolistRepository
 */
public interface TodolistRepository {

  Todolist[] getAll();

  void add(Todolist todolist);

  boolean remove(Integer number);
}
