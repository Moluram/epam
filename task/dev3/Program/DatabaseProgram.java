package com.moluram.task.dev3.Program;

import com.moluram.task.dev3.Program.Mediators.IOMediator;
import com.moluram.task.dev3.Program.Operations.IOperation;

import java.util.List;

/**
 * Represent a main class for this application. Starts all the work in application
 */
public class DatabaseProgram {
  private static final String WELCOME_LINE = "Available operations: \n";
  private static final StringBuilder EMPTY_STRING = new StringBuilder("");
  private static final String TO_NEXT_LINE = "\n";
  private static final String OPERATION_NOT_FOUND = "Operation not found!";
  private static final String EXIT_HELP = " - exit - to quit the program\n";
  private static final java.lang.String SPACE = " ";
  private static final int FIRST_ELEMENT = 0;
  private static final String EXIT = "exit";

  /**
   * Operations to use in execution
   */
  private List<IOperation> operationList;

  /**
   * Mediator to work with input output
   */
  private IOMediator ioMediator;

  /**
   * Simple constructor
   * @param listOfOperations - operations to use in execution
   * @param ioMediator - mediator to work with input output
   */
  public DatabaseProgram(List<IOperation> listOfOperations, IOMediator ioMediator) {
    this.ioMediator = ioMediator;
    this.operationList = listOfOperations;
  }

  /**
   * Starts execution of the program
   */
  public void start() {
    ioMediator.print(WELCOME_LINE + createHelpLine());
    String[] line;
    IOperation foundOperation;
    while (true) {
      line = ioMediator.getNextLine().split(SPACE);
      if (line[FIRST_ELEMENT].toLowerCase().equals(EXIT)) {
        break;
      }
      foundOperation = tryToFoundOperation(line[FIRST_ELEMENT]);
      tryToExecuteOperation(foundOperation, line);
      foundOperation = null;
    }
  }

  /**
   * Tries to find operation in operationList
   * @param operationLine - line which represents operation
   * @return IOperation - found operation
   */
  private IOperation tryToFoundOperation(String operationLine) {
    for (IOperation operation: operationList) {
      if (operation.isFits(operationLine)) {
        return operation;
      }
    }
    return null;
  }

  /**
   * Tries to execute operation
   * @param foundOperation - operation to execute
   * @param line - line for the operation
   */
  private void tryToExecuteOperation(IOperation foundOperation, String[] line) {
    if (foundOperation != null) {
      foundOperation.execute(line);
    } else {
      ioMediator.print(OPERATION_NOT_FOUND);
    }
  }

  /**
   * Creating a line with help for all existing operations
   * @return String - string help line
   */
  private String createHelpLine() {
    StringBuilder output = EMPTY_STRING;
    for (IOperation operation: operationList) {
      output.append(operation.getOperationHelp()).append(TO_NEXT_LINE);
    }
    return output.append(EXIT_HELP).toString();
  }
}
