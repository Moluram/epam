package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for era.
 */
public class GGDatePattern extends DatePattern {
  private static final String PATTERN = "gg";
  private final Calendar date;

  public GGDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.ERA));
  }
}
