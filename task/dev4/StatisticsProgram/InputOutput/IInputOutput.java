package com.moluram.task.dev4.StatisticsProgram.InputOutput;

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
   * Print line to somewhere
   * @param line - line to output
   */
  void printLine(String line);
}
