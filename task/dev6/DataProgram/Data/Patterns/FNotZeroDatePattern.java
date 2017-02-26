package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a hundredths of a second in a date and time.
 * Gets in range from 1 - 9. If equals 0 or less returns empty string
 */
public class FNotZeroDatePattern extends DatePattern {
  private static final String PATTERN = "F";
  private static final int HUNDRED_TO_GET_TENTHS = 100;
  private static final String EMPTY = "";
  private final Calendar date;

  public FNotZeroDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.MILLISECOND) / HUNDRED_TO_GET_TENTHS;
    return String.valueOf(result > 0 ? result : EMPTY);
  }
}
