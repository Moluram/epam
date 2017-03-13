package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DDDayOfMonthsDatePattern;
import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for number of day. Gets days in range 00 - 31
 */
public class DDDayOfMonthsDatePatternTest {
  private int DDDayOfMonthsDatePattern_LENGTH = 2;
  private int DDayOfMonthsDatePattern_MIN_NUMBER = 0;
  private int DDayOfMonthsDatePattern_MAX_NUMBER = 31;

  @Test
  public void DDDayOfMonthsDatePatternTestQuantityOfNumbers() {
    String number = new DDDayOfMonthsDatePattern(Calendar.getInstance()).getResult();
    Assert.assertEquals(DDDayOfMonthsDatePattern_LENGTH, number.length());
  }

  @Test
  public void DDDayOfMonthsDatePatternTest() {
    int number = Integer.parseInt(new DDDayOfMonthsDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= DDayOfMonthsDatePattern_MIN_NUMBER &&
        number <= DDayOfMonthsDatePattern_MAX_NUMBER);
  }
}
