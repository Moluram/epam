package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 00 - 23
 */
public class HHFullDatePatternTest {
  private int HHFullDatePattern_LENGTH = 2;
  private int HHFullDatePattern_MAX_NUMBER = 23;
  private int HHFullDatePattern_MIN_NUMBER = 0;

  @Test
  public void HHDatePatternTestQuanityOfNumbers() {
    String number = new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult();
    Assert.assertEquals(HHFullDatePattern_LENGTH, number.length());
  }

  @Test
  public void HHDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= HHFullDatePattern_MIN_NUMBER && number <= HHFullDatePattern_MAX_NUMBER);
  }
}
