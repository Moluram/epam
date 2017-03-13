package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for a thousandth of a second in a date and time.
 * Gets in range from 000 - 999
 */
public class FFFDatePatternTest  {
  private int FFFDatePattern_LENGTH = 3;
  private int FFFDatePattern_MIN_NUMBER = 0;
  private int FFFDatePattern_MAX_NUMBER = 999;


  @Test
  public void FFFDatePatternTestQuanityOfNumbers() {
    String number = new com.moluram.task.dev6.DataProgram.Data.Patterns.FFFDatePattern(Calendar.getInstance()).getResult();
    Assert.assertEquals(FFFDatePattern_LENGTH, number.length());
  }

  @Test
  public void FFFDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= FFFDatePattern_MIN_NUMBER && number <= FFFDatePattern_MAX_NUMBER);
  }
}
