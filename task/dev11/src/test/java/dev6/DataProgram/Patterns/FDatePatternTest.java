package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a tenths of a second in a date and time.
 * Gets in range from 0 - 9
 */
public class FDatePatternTest {
  private static int FDatePattern_MIN_NUMBER = 0;
  private static int FDatePattern_MAX_NUMBER = 9;

  @Test
  public void FDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= FDatePattern_MIN_NUMBER && number <= FDatePattern_MAX_NUMBER);
  }
}
