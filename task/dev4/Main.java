package com.moluram.task.dev4;

import com.moluram.task.dev4.StatisticsProgram.DataBase.FakeDatabase;
import com.moluram.task.dev4.StatisticsProgram.InputOutput.ConsoleIO;
import com.moluram.task.dev4.StatisticsProgram.TextStatistic;

/**
 * Class serves for executing the program
 */
public class Main {
  private static final int DEFAULT_COUNT_OF_ITERATIONS = 3;
  private static final int NUMBER_OF_NEEDED_LETTERS = 5;
  private static final int NUMBER_OF_LETTERS_FOR_A_PACK = 2;

  /**
   * Executes the performance of a TextStatistic class
   * @param args - arguments from a command line
   */
  public static void main(String[] args) {
    TextStatistic textStatistic = new TextStatistic(new ConsoleIO(), new FakeDatabase(),
        DEFAULT_COUNT_OF_ITERATIONS, NUMBER_OF_NEEDED_LETTERS, NUMBER_OF_LETTERS_FOR_A_PACK);
    textStatistic.execute();
  }
}
