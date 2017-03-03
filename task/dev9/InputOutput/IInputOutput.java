package com.moluram.task.dev9.InputOutput;

/**
 * Provides input-output service
 */
public interface IInputOutput {
  /**
   * Get next line from somewhere
   * @return - new line
   */
  String getNextLine();

  /**
   * Outputs message and gets next line from somewhere
   * @return - new line
   */
  String getNextLine(String message);

  /**
   * Print line to somewhere
   * @param line - line to output
   */
  void printLine(String line);
}
