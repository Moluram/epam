package com.moluram.task.dev3.Program.DataBase;

import com.moluram.task.dev3.Program.DataObjects.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Class serves for emulating working database
 */
public class FakeDatabase implements IDatabase {
  /**
   * List of existing users
   */
  private List<User> userList = new LinkedList<>();

  /**
   * Adds user to the database
   * @param user - user to add
   */
  @Override
  public void addUser(User user) {
    userList.add(user);
  }

  /**
   * Returns list with all users
   * @return List<User> - list with users
   */
  @Override
  public List<User> getAllUsers() {
    return userList;
  }
}
