package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 0 - 23
 */
public class HFullDatePatternTest {
  private int HFullDatePattern_MAX_NUMBER = 23;
  private int HFullDatePattern_MIN_NUMBER = 0;

  @Test
  public void HDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= HFullDatePattern_MIN_NUMBER && number <= HFullDatePattern_MAX_NUMBER);
  }
}
