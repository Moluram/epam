package com.moluram.task.dev7.DataProgram.Date.Patterns;

/**
 * Represent an abstract date format pattern for seconds.
 * Gets in range from 00 - 59
 */
public class SSDatePattern extends DatePattern {
  private static final String PATTERN = "ss";
  private static final int MIN_SIZE_OF_PATTERN = 2;
  private static final String NON_DIGITS_REGEX = "[^0-9]";
  private static final int MAX_NUMBER = 60;
  private static final int MIN_NUMBER = 0;

  public SSDatePattern() {
    super(PATTERN);
  }

  @Override
  public boolean isSupport(String line) {
    boolean answer = false;
    if (line.length() == MIN_SIZE_OF_PATTERN && !line.matches(NON_DIGITS_REGEX)) {
      answer = isNumberInValidRange(Integer.parseInt(line));
    }
    return answer;
  }

  /**
   * Checks whether the number in valid range in this pattern
   * @param number - number to check
   * @return boolean - answer
   */
  private boolean isNumberInValidRange(int number) {
    return number < MAX_NUMBER && number >= MIN_NUMBER;
  }
}
