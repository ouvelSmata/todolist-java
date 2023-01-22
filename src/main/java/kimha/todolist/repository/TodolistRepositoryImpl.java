package kimha.todolist.repository;

import kimha.todolist.entity.Todolist;

/**
 * TodolistRepositoryImpl
 */
public class TodolistRepositoryImpl implements TodolistRepository{

  public Todolist[] data = new Todolist[10];

  @Override
  public Todolist[] getAll() {
    return data;
  }

  @Override
  public void add(Todolist todolist) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void remove(Integer number) {
    // TODO Auto-generated method stub
    
  }

  
}
