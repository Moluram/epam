package com.moluram.task.dev3.Program.Mediators;

import com.moluram.task.dev3.Program.DataBase.IDatabase;
import com.moluram.task.dev3.Program.DataObjects.User;

import java.util.List;

/**
 * Provides access to the database
 */
public class DatabaseMediator {
  /**
   * Object with whom mediator works
   */
  private IDatabase database;

  /**
   * Simple constructor
   * @param database - database to work with
   */
  public DatabaseMediator(IDatabase database) {
    this.database = database;
  }

  /**
   * Requests database to add user
   * @param user - user to add
   */
  public void addUserToDatabase(User user) {
    database.addUser(user);
  }

  /**
   * Requests database to give full list of users
   * @return List<User> - list of users
   */
  public List<User> getAllUsersFromDatabase() {
    return database.getAllUsers();
  }
}
