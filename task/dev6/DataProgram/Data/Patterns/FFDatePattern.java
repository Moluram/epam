package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a hundredths of a second in a date and time.
 * Gets in range from 00 - 99
 */
public class FFDatePattern extends DatePattern {
  private static final String PATTERN = "ff";
  private static final String ZERO = "0";
  private static final int TEN_TO_GET_HUNDREDTHS = 10;
  private static final int NOT_TWO_NUMBERS = 10;
  private final Calendar date;

  public FFDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.MILLISECOND) / TEN_TO_GET_HUNDREDTHS;
    return String.valueOf(result < NOT_TWO_NUMBERS ? ZERO + result : result);
  }
}
