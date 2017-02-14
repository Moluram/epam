package com.moluram.task.dev3.Program.Operations;

import com.moluram.task.dev3.Program.DataObjects.User;
import com.moluram.task.dev3.Program.Mediators.DatabaseMediator;
import com.moluram.task.dev3.Program.Mediators.IOMediator;

import java.util.LinkedList;
import java.util.List;

/**
 * Represent an adding operation for a program
 */
public class TheOldestUserOperation implements IOperation  {
  private static final String HELP_FOR_THE_OLDEST_USER = " - theoldest - prints the oldest user";
  private static final Integer MINIMAL_VALUE = 0;
  private static final String OPERATION = "theoldest";

  /**
   * Mediator to work with database
   */
  private DatabaseMediator databaseMediator;

  /**
   * Mediator to work with input output
   */
  private IOMediator ioMediator;

  /**
   * Simple constructor
   * @param databaseMediator - mediator to work with database
   * @param ioMediator - mediator to work with input output
   */
  public TheOldestUserOperation(DatabaseMediator databaseMediator, IOMediator ioMediator) {
    this.databaseMediator = databaseMediator;
    this.ioMediator = ioMediator;
  }

  /**
   * Returns the help line to this operation
   * @return String - help line
   */
  @Override
  public String getOperationHelp() {
    return HELP_FOR_THE_OLDEST_USER;
  }

  /**
   * Determines whether the given string is this operation name
   * @param line - line to check
   * @return boolean - answer
   */
  @Override
  public boolean isFits(String line) {
    return line.toLowerCase().equals(OPERATION);
  }

  /**
   * Starts the execution of this operation
   * @param line - line for operation
   */
  @Override
  public void execute(String[] line) {
    List<User> users = databaseMediator.getAllUsersFromDatabase();
    User oldestUser = null;
    Integer maxAge = MINIMAL_VALUE;
    for (User user: users) {
      if (user.getAge() > maxAge) {
        maxAge = user.getAge();
        oldestUser = user;
      }
    }
    if (oldestUser != null) {
      ioMediator.print(oldestUser.toString());
    }
  }
}
