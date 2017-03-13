package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for seconds.
 * Gets in range from 00 - 59
 */
public class SSDatePattern extends DatePattern {
  private static final String PATTERN = "ss";
  private static final String ZERO = "0";
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public SSDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.SECOND);
    return String.valueOf(result < LESS_THAN_TEN ?
        ZERO + result : result);
  }
}
