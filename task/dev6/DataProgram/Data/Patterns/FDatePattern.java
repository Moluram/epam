package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a tenths of a second in a date and time.
 * Gets in range from 0 - 9
 */
public class FDatePattern extends DatePattern {
  private static final String PATTERN = "f";
  private static final int HUNDRED_TO_GET_TENTHS = 100;
  private final Calendar date;

  public FDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.MILLISECOND) / HUNDRED_TO_GET_TENTHS);
  }
}
