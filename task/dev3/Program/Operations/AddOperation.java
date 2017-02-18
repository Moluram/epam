package com.moluram.task.dev3.Program.Operations;

import com.moluram.task.dev3.Program.DataObjects.User;
import com.moluram.task.dev3.Program.Mediators.DatabaseMediator;
import com.moluram.task.dev3.Program.Mediators.IOMediator;

/**
 * Represent an adding to the database operation for a program
 */
public class AddOperation implements IOperation {
  private static final String ADDING_HELP = " - add <name> <surname> <sex> <age>\n" +
      " <name>, <surname>, <sex>(can be male or female) and <age> are parameters of a user";
  private static final String OPERATION = "add";
  private static final java.lang.String SPACE = " ";
  private static final String WRONG_NUMBER_OF_ARGUMENTS = "Wrong number of arguments!";
  private static final int FIRST_ELEMENT = 1;
  private static final int SECOND_ELEMENT = 2;
  private static final int THIRD_ELEMENT = 3;
  private static final int FOURTH_ELEMENT = 4;

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
  public AddOperation(DatabaseMediator databaseMediator, IOMediator ioMediator) {
    this.databaseMediator = databaseMediator;
    this.ioMediator = ioMediator;
  }

  /**
   * Returns the help line to this operation
   * @return String - help line
   */
  @Override
  public String getOperationHelp() {
    return ADDING_HELP;
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
   * Starts the execution of adding operation
   * @param line - line for operation
   */
  @Override
  public void execute(String[] line) {
    try {
      databaseMediator.addUserToDatabase(new User(line[FIRST_ELEMENT],
          line[SECOND_ELEMENT],
          line[THIRD_ELEMENT],
          Integer.parseInt(line[FOURTH_ELEMENT])));
    } catch (NumberFormatException e) {
      ioMediator.print(e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
      ioMediator.print(WRONG_NUMBER_OF_ARGUMENTS);
    }
  }
}
