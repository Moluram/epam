package com.moluram.task.dev3.Program.Operations;

import com.moluram.task.dev3.Program.DataObjects.User;
import com.moluram.task.dev3.Program.GlobalConstants;
import com.moluram.task.dev3.Program.Mediators.DatabaseMediator;
import com.moluram.task.dev3.Program.Mediators.IOMediator;

import java.util.HashMap;
import java.util.List;

/**
 * Represent an operation to find the most popular female name for a program
 */
public class TheMostPopularFemaleNameOperation implements IOperation  {
  private static final String FEMALE_NAME_HELP = " - tmpfn - returns the most popular female name";
  private static final String OPERATION = "tmpfn";
  private static final Integer ONE_FOR_THE_START = 1;
  private static final Integer MINIMAL_USAGE = 0;
  private static final String EMPTY_STRING = "";

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
  public TheMostPopularFemaleNameOperation(DatabaseMediator databaseMediator, IOMediator ioMediator) {
    this.databaseMediator = databaseMediator;
    this.ioMediator = ioMediator;
  }

  /**
   * Returns the help line to this operation
   * @return String - help line
   */
  @Override
  public String getOperationHelp() {
    return FEMALE_NAME_HELP;
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
    Integer number;
    HashMap<String ,Integer> namesMap = new HashMap<>();
    for (User user : users) {
      if (user.getSex().equals(GlobalConstants.FEMALE)) {
        if (!namesMap.containsKey(user.getName())) {
          namesMap.put(user.getName(), ONE_FOR_THE_START);
        } else {
          number = namesMap.remove(user.getName());
          namesMap.put(user.getName(), ++number);
        }
      }
    }
    printMoreCommonSurname(namesMap);
  }

  /**
   * Finds and print most common name in HashMap
   * @param namesMap - map with names and the number of their repetitions
   */
  private void printMoreCommonSurname(HashMap<String, Integer> namesMap) {
    String maxUsageName = EMPTY_STRING;
    Integer maxUsage = MINIMAL_USAGE;
    for (String name: namesMap.keySet()) {
      if (namesMap.get(name) > maxUsage) {
        maxUsage = namesMap.get(name);
        maxUsageName = name;
      }
    }
    ioMediator.print(maxUsageName);
  }
}
