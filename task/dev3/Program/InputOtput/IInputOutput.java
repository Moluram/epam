package com.moluram.task.dev3.Program.InputOtput;

/**
 * Provides input-output service
 */
public interface IInputOutput {
  /**
   * Get next line from somewhere
   * @return - new line
   */
  public String getNextLine();

  /**
   * Print line to somewhere
   * @param line - line to output
   */
  public void printLine(String line);
}
