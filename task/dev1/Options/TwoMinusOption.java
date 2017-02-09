package com.moluram.task.dev1.Options;

/**
 * Created by Moluram on 09.02.2017.
 */
public class TwoMinusOption implements Option {
  private static final String TWO_MINUSES = "--";
  private static final String SINGLE_MINUS = "-";
  private static final String EMPTY_STRING = "";
  private static final int START_OF_VALUE = 0;
  private static final int END_OF_TWO_MINUSES = 2;

  /**
   * Checks given value two minuses rule
   * @param value - value for a check
   * @return boolean - answer of a check
   */
  @Override
  public boolean check(String value) {
    if (value.substring(START_OF_VALUE, END_OF_TWO_MINUSES).equals(TWO_MINUSES)) {
      value = value.replaceFirst(TWO_MINUSES, EMPTY_STRING);
      return !(value.contains(TWO_MINUSES) || value.contains(SINGLE_MINUS));
    }
    return false;
  }
}
