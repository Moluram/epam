package com.moluram.task.dev1.Options;

/**
 * Created by Moluram on 09.02.2017.
 */
public class SlashOption implements Option {
  private static final String SLASH = "/";
  private static final int FIRST_LETTER = 0;
  private static final String EMPTY_STRING = "";

  /**
   * Checks given value with slash rule
   * @param value - value for a check
   * @return boolean - answer of a check
   */
  @Override
  public boolean check(String value) {
    if (SLASH.charAt(FIRST_LETTER) == value.charAt(FIRST_LETTER)) {
      value = value.replaceFirst(SLASH, EMPTY_STRING);
      return !value.contains(SLASH);
    }
    return false;
  }
}
