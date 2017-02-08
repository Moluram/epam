package com.moluram.task.dev1;

import com.moluram.task.dev1.Helpers.Executor;

/**
 * Class serves for starting execution of the program
 */
public class Main {
  /**
   * Starts execution of the tester
   * @param args - command line arguments
   */
  public static void main(String[] args) {
    Executor tester = new Executor();
    tester.executeElector(args);
  }
}
