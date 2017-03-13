package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for years.
 * Gets in range from 0 - 99
 */
public class YDatePattern extends DatePattern {
  private static final String PATTERN = "y";
  private static final int HUNDRED = 100;
  private final Calendar date;

  public YDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.YEAR) % HUNDRED);
  }
}
