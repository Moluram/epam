package com.moluram.task.dev3.Program.Operations;

/**
 * Determines the behavior of operations
 */
public interface IOperation {
  /**
   * Returns the help line to this operation
   * @return String - help line
   */
  String getOperationHelp();

  /**
   * Determines whether the given string is this operation name
   * @param line - line to check
   * @return boolean - answer
   */
  boolean isFits(String line);

  /**
   * Starts the execution of this operation
   * @param line - line for operation
   */
  void execute(String[] line);
}
