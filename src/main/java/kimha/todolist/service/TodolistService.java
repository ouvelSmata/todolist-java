package kimha.todolist.service;

/**
 * TodolistService
 */
public interface TodolistService {

  void showTodolist();

  void addTodolist(String todo);

  void removeTodolist(Integer number);
}
