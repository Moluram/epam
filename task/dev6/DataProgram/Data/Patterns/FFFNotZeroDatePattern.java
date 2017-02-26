package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a thousandth of a second in a date and time.
 * Gets in range from 001 - 999. If equals 000 or less returns empty string
 */
public class FFFNotZeroDatePattern extends DatePattern {
  private static final String PATTERN = "FFF";
  private static final String EMPTY = "";
  private static final String ZERO = "0";
  private static final int LESS_THAN_HUNDREDTH = 100;
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public FFFNotZeroDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.MILLISECOND);
    return String.valueOf(result > 0 ?
        (result < LESS_THAN_HUNDREDTH ?
            ZERO + (result < LESS_THAN_TEN ?
                ZERO + result : result)
            : result)
        : EMPTY);
  }
}
