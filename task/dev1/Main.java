package com.moluram.task.dev1;

import com.moluram.task.dev1.Tester.Tester;

/**
 * Class serves for starting execution of the program
 */
public class Main {
  /**
   * Starts execution of the tester
   * @param args - command line arguments
   */
  public static void main(String[] args) {
    Tester tester = new Tester();
    tester.testElector(args);
  }
}
