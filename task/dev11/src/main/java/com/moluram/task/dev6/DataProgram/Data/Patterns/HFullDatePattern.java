package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 0 - 23
 */
public class HFullDatePattern extends DatePattern {
  private static final String PATTERN = "H";
  private final Calendar date;

  public HFullDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.HOUR_OF_DAY));
  }
}
