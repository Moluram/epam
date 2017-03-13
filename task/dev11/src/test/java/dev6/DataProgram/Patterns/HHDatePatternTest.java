package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for hours.
 * Gets in range from 01 - 12
 */
public class HHDatePatternTest {
  private int HHDatePattern_LENGTH = 2;
  private int HHDatePattern_MAX_NUMBER = 12;
  private int HHDatePattern_MIN_NUMBER = 1;

  @Test
  public void HHDatePatternTestQuanityOfNumbers() {
    String number = new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult();
    Assert.assertEquals(HHDatePattern_LENGTH, number.length());
  }

  @Test
  public void HHDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= HHDatePattern_MIN_NUMBER && number <= HHDatePattern_MAX_NUMBER);
  }
}
