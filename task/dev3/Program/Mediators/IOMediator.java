package com.moluram.task.dev3.Program.Mediators;

import com.moluram.task.dev3.Program.DataObjects.User;
import com.moluram.task.dev3.Program.InputOtput.IInputOutput;

/**
 * Provides access to input-output
 */
public class IOMediator {
  private static final String SPACE = " ";

  /**
   * Object with whom mediator works
   */
  private IInputOutput inputOutput;

  /**
   * Simple constructor
   * @param inputOutput - io to work with (inputOutput)
   */
  public IOMediator(IInputOutput inputOutput) {
    this.inputOutput = inputOutput;
  }

  /**
   * Asks io object to get next line
   * @return String - nextline
   */
  public String getNextLine() {
    return inputOutput.getNextLine();
  }

  /**
   * Asks io object to print string
   * @param line - line to print
   */
  public void print(String line) {
    inputOutput.printLine(line);
  }
}
