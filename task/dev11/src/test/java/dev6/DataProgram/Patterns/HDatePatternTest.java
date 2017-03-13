package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 1 - 12
 */
public class HDatePatternTest {
  private int HDatePattern_MAX_NUMBER = 12;
  private int HDatePattern_MIN_NUMBER = 1;

  @Test
  public void HDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= HDatePattern_MIN_NUMBER && number <= HDatePattern_MAX_NUMBER);
  }
}
