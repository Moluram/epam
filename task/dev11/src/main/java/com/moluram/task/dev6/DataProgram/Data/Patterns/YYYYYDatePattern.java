package com.moluram.task.dev6.DataProgram.Data.Patterns;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for years.
 * Gets in range from 00000
 */
public class YYYYYDatePattern extends DatePattern {
  private static final String PATTERN = "yyyyy";
  private static final String ZERO = "0";
  private static final int LESS_THAN_TEN_THOUSANDS = 10000;
  private static final int LESS_THAN_THOUSANDS = 1000;
  private static final int LESS_THAN_HUNDREDTH = 100;
  private static final int LESS_THAN_TEN = 10;
  private final Calendar date;

  public YYYYYDatePattern(Calendar date) {
    super(PATTERN);
    this.date = date;
  }

  @Override
  public String getResult() {
    int result = date.get(Calendar.YEAR);
    return String.valueOf(result < LESS_THAN_TEN_THOUSANDS ?
        ZERO + (result < LESS_THAN_THOUSANDS ?
            ZERO + (result < LESS_THAN_HUNDREDTH ?
                ZERO + (result < LESS_THAN_TEN ?
                    ZERO + result : result) : result)
            : result)
        : result);
  }
}
