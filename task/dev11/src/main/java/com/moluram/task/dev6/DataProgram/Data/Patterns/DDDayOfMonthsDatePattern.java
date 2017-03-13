package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for number of day. Gets days in range 00 - 31
 */
public class DDDayOfMonthsDatePattern extends DatePattern {
  private static final String PATTERN = "DD";
  private static final int NOT_TWO_NUMBERS = 10;
  private static final String ZERO = "0";
  private final Calendar date;

  public DDDayOfMonthsDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result  = date.get(Calendar.DAY_OF_MONTH);
    String stringResult = String.valueOf(result);
    return result < NOT_TWO_NUMBERS ? ZERO + stringResult : stringResult;
  }
}
