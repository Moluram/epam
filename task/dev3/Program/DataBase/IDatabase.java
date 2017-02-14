package com.moluram.task.dev3.Program.DataBase;

import com.moluram.task.dev3.Program.DataObjects.User;

import java.util.List;

/**
 * Provides database behavior
 */
public interface IDatabase {
  /**
   * Adds user to the database
   * @param user - user to add
   */
  void addUser(User user);

  /**
   * Returns list with all users
   * @return List<User> - list with users
   */
  List<User> getAllUsers();
}
