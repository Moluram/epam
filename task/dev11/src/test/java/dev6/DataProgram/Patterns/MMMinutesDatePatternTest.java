package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for minutes.
 * Gets in range from 00 - 59
 */
public class MMMinutesDatePatternTest {
  private int MMMinutesDatePattern_LENGTH = 2;
  private int MMMinutesDatePattern_MAX_NUMBER = 59;
  private int MMMinutesDatePattern_MIN_NUMBER = 0;

  @Test
  public void MMMinutesDatePatternTestQuanityOfNumbers() {
    String number = new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult();
    Assert.assertEquals(MMMinutesDatePattern_LENGTH, number.length());
  }

  @Test
  public void MMMinutesDatePatternTest() {
    int number = Integer.parseInt(new com.moluram.task.dev6.DataProgram.Data.Patterns.FFDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= MMMinutesDatePattern_MIN_NUMBER && number <= MMMinutesDatePattern_MAX_NUMBER);
  }
}
