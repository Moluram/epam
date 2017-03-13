package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DDayOfMonthsDatePattern;
import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Represent an abstract date format pattern for number of day. Gets days in range 0 - 31
 */
public class DDayOfMonthsDatePatternTest {
  private static int DDayOfMonthsDatePattern_MIN_NUMBER = 0;
  private static int DDayOfMonthsDatePattern_MAX_NUMBER = 31;

  @Test
  public void test() {
    int number = Integer.parseInt(new DDayOfMonthsDatePattern(Calendar.getInstance()).getResult());
    Assert.assertTrue(number >= DDayOfMonthsDatePattern_MIN_NUMBER &&
        number <= DDayOfMonthsDatePattern_MAX_NUMBER);
  }
}
