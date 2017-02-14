package com.moluram.task.dev3.Program.Operations;

import com.moluram.task.dev3.Program.DataObjects.User;
import com.moluram.task.dev3.Program.Mediators.DatabaseMediator;
import com.moluram.task.dev3.Program.Mediators.IOMediator;

import java.util.LinkedList;
import java.util.List;

/**
 * Represent an finder for a namesakes operation for a program
 */
public class NamesakesOperation implements IOperation  {
  private static final String NAMESAKES_HELP = " - namesakes - displays all namesakes in database";
  private static final String OPERATION = "namesakes";

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
  public NamesakesOperation(DatabaseMediator databaseMediator, IOMediator ioMediator) {
    this.databaseMediator = databaseMediator;
    this.ioMediator = ioMediator;
  }

  /**
   * Returns the help line to this operation
   * @return String - help line
   */
  @Override
  public String getOperationHelp() {
    return NAMESAKES_HELP;
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
   * Starts the execution of namesakes operation
   * @param line - line for operation
   */
  @Override
  public void execute(String[] line) {
    List<User> users = databaseMediator.getAllUsersFromDatabase();
    List<String> listOfSurnames = new LinkedList<>();
    for (User user: users) {
      if (listOfSurnames.contains(user.getSurname())) {
        ioMediator.print(user.toString());
      } else {
        listOfSurnames.add(user.getSurname());
      }
    }
  }
}
