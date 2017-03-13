package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Represent an abstract date format pattern for day of week.
 * Gets days in range from Monday - Sunday
 */
public class DDDDDayOfWeekDatePatternTest {

  @Test
  public void DDDDDayOfWeekDatePatternTest(){
    List<String> days = new ArrayList<>();
    days.addAll(Arrays.asList(new String[]{"Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday",
        "Sunday"}));
    String day = new com.moluram.task.dev6.DataProgram.Data.Patterns.DDDDDayOfWeekDatePattern(Calendar.getInstance()).getResult();
    Assert.assertTrue(days.contains(day));
  }
}
