package com.moluram.task.dev1.Options;

/**
 * Created by Moluram on 09.02.2017.
 */
public class SingleMinusOption implements Option {
  private static final String SINGLE_MINUS = "-";
  private static final int NUMBER_OF_LETTERS_IN_SENTENCE = 2;
  private static final int FIRST_LETTER = 0;
  private static final String EMPTY_STRING = "";

  /**
   * Checks given value with single minus rule
   * @param value - value for a check
   * @return boolean - answer of a check
   */
  @Override
  public boolean check(String value) {
    if(value.length() == NUMBER_OF_LETTERS_IN_SENTENCE) {
      if (SINGLE_MINUS.charAt(FIRST_LETTER) == value.charAt(FIRST_LETTER)) {
        return !value.replaceFirst(SINGLE_MINUS, EMPTY_STRING).contains(SINGLE_MINUS);
      }
    }
    return false;
  }
}
