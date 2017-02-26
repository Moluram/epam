package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for seconds.
 * Gets in range from 0 - 59
 */
public class SDatePattern extends DatePattern {
  private static final String PATTERN = "s";
  private final Calendar date;

  public SDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.SECOND));
  }
}
