package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for AM / PM indicator.
 * Gets AM or PM
 */
public class TTDatePattern extends DatePattern {
  private static final String PATTERN = "tt";
  private final Calendar date;

  private enum AM_PM {
    AM, PM
  }

  public TTDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return AM_PM.values()[date.get(Calendar.AM_PM)].name();
  }
}
