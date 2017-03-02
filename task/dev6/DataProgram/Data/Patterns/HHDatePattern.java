package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 01 - 12
 */
public class HHDatePattern extends DatePattern {
  private static final String PATTERN = "hh";
  private static final String ZERO = "0";
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public HHDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.HOUR);
    return String.valueOf(result < LESS_THAN_TEN ? ZERO + result : result);
  }
}
