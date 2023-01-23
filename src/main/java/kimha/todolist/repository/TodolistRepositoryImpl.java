package kimha.todolist.repository;

import kimha.todolist.entity.Todolist;

/**
 * TodolistRepositoryImpl
 */
public class TodolistRepositoryImpl implements TodolistRepository {

  private Todolist[] data = new Todolist[10];

  @Override
  public Todolist[] getAll() {
    return data;
  }

  private boolean isFull() {
    boolean isFull = true;

    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        isFull = false;
      }
    }

    return isFull;
  }

  private void resizeIfFull() {
    if (isFull()) {
      Todolist[] temp = data;
      data = new Todolist[data.length * 2];

      for (int i = 0; i < temp.length; i++) {
        data[i] = temp[i];
      }
    }
  }

  @Override
  public void add(Todolist todolist) {
    resizeIfFull();

    for (int i = 0; i < data.length; i++) {
      if (data[i] == null) {
        data[i] = todolist;
        break;
      }
    }
  }

  @Override
  public void remove(Integer number) {
    // TODO Auto-generated method stub

  }

}
