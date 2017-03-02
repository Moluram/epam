package com.moluram.task.dev6;

import com.moluram.task.dev3.Program.InputOtput.ConsoleIO;
import com.moluram.task.dev6.DataProgram.DateProgram;

/**
 * Serve for executing the program
 */
public class Main {
  /**
   * Executes the program
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    DateProgram dateProgram = new DateProgram(new ConsoleIO());
    dateProgram.execute();
  }
}
