package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import com.moluram.task.dev6.DataProgram.Data.Patterns.MMMMMonthsDatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Represent an abstract date format pattern for months.
 * Gets in range from January - December
 */
public class MMMMMonthsDatePatternTest {
  @Test
  public void DDDDayOfWeekDatePatternTest() {
    List<String> days = new ArrayList<>();
    days.addAll(Arrays.asList(new String[] {"January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"}));
    String day = new MMMMMonthsDatePattern(Calendar.getInstance()).getResult();
    Assert.assertTrue(days.contains(day));
  }
}
