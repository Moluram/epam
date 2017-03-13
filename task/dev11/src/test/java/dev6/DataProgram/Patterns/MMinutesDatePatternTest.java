package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for minutes.
 * Gets in range from 0 - 59
 */
public class MMinutesDatePatternTest {
  private int MMinutesDatePattern_MAX_NUMBER = 12;
  private int MMinutesDatePattern_MIN_NUMBER = 1;

  @Test
  public void HDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= MMinutesDatePattern_MIN_NUMBER && number <= MMinutesDatePattern_MAX_NUMBER);
  }
}
