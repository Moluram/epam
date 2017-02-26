package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for minutes.
 * Gets in range from 0 - 59
 */
public class MMinutesDatePattern extends DatePattern {
  private static final String PATTERN = "m";
  private final Calendar date;

  public MMinutesDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.MINUTE));
  }
}
