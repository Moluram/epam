package com.moluram.task.dev6.DataProgram.Data;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;

import java.util.List;

/**
 * Date abstractions to work with
 */
public class Date {
  /**
   * List of pattern to use
   */
  private final List<DatePattern> listOfPatterns;

  /**
   * Creates object of Date
   * @param listOfPatterns - list of pattern to use
   */
  Date(List<DatePattern> listOfPatterns) {
    this.listOfPatterns = listOfPatterns;
  }

  /**
   * Returns list of pattern to use
   */
  public List<DatePattern> getListOfPatterns() {
    return listOfPatterns;
  }
}
