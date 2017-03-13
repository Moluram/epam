package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for minutes.
 * Gets in range from 00 - 59
 */
public class MMMinutesDatePattern extends DatePattern {
  private static final String PATTERN = "mm";
  private static final String ZERO = "0";
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public MMMinutesDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.MINUTE);
    return String.valueOf(result < LESS_THAN_TEN ?
        ZERO + result : result);
  }
}
