package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a hundredths of a second in a date and time.
 * Gets in range from 00 - 99
 */
public class FFDatePatternTest {
  private int FFDatePattern_LENGTH = 2;
  private int FFDatePattern_MIN_NUMBER = 0;
  private int FFDatePattern_MAX_NUMBER = 99;

  @Test
  public void FFDatePatternTestQuanityOfNumbers() {
    String number = new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult();
    Assert.assertEquals(FFDatePattern_LENGTH, number.length());
  }

  @Test
  public void FFDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= FFDatePattern_MIN_NUMBER && number <= FFDatePattern_MAX_NUMBER);
  }
}
