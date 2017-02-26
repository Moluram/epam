package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for number of day. Gets days in range 0 - 31
 */
public class DDayOfMonthsDatePattern extends DatePattern {
  private static final String PATTERN = "D";
  private final Calendar date;

  public DDayOfMonthsDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    return String.valueOf(date.get(Calendar.DAY_OF_MONTH));
  }
}
