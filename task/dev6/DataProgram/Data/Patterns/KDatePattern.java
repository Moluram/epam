package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for data on the time zone.
 */
public class KDatePattern extends DatePattern {
  private static final String PATTERN = "h";
  private final Calendar date;

  public KDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.ZONE_OFFSET);
    return String.valueOf(result);
  }
}
