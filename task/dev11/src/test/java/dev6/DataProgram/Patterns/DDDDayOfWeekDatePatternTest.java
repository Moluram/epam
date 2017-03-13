package dev6.DataProgram.Patterns;

import com.moluram.task.dev6.DataProgram.Data.Patterns.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Represent an abstract date format pattern for day of week. Gets days in range from Mon - Sun
 */
public class DDDDayOfWeekDatePatternTest {

  @Test
  public void DDDDayOfWeekDatePatternTest() {
    List<String> days = new ArrayList<>();
    days.addAll(Arrays.asList(new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}));
    String day = new com.moluram.task.dev6.DataProgram.Data.Patterns.DDDDayOfWeekDatePattern(Calendar.getInstance()).getResult();
    Assert.assertTrue(days.contains(day));
  }
}
