package com.moluram.task.dev6.DataProgram.Data;

import com.moluram.task.dev6.DataProgram.Data.Patterns.*;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Serve for creating Date object
 */
public class DateFactory {
  /**
   * Creates Date object
   * @return Date
   */
  public Date getDateObject() {
    return new Date(createListOfPatterns());
  }

  /**
   * Creates list of patterns to use in Date
   * @return List<DatePattern>
   */
  private List<DatePattern> createListOfPatterns() {
    List<DatePattern> patterns = new LinkedList<>();
    Calendar date = Calendar.getInstance();
    patterns.add(new DDDDDayOfWeekDatePattern(date));
    patterns.add(new DDDayOfMonthsDatePattern(date));
    patterns.add(new DDDDayOfWeekDatePattern(date));
    patterns.add(new DDayOfMonthsDatePattern(date));

    patterns.add(new FDatePattern(date));
    patterns.add(new FFDatePattern(date));
    patterns.add(new FFFDatePattern(date));
    patterns.add(new FNotZeroDatePattern(date));
    patterns.add(new FFNotZeroDatePattern(date));
    patterns.add(new FFFNotZeroDatePattern(date));

    patterns.add(new GDatePattern(date));
    patterns.add(new GGDatePattern(date));

    patterns.add(new HDatePattern(date));
    patterns.add(new HHDatePattern(date));
    patterns.add(new HFullDatePattern(date));
    patterns.add(new HHFullDatePattern(date));

    patterns.add(new KDatePattern(date));

    patterns.add(new MMinutesDatePattern(date));
    patterns.add(new MMMinutesDatePattern(date));

    patterns.add(new MMMonthDatePattern(date));
    patterns.add(new MMonthDatePattern(date));
    patterns.add(new MMMMonthDatePattern(date));
    patterns.add(new MMMMMonthsDatePattern(date));

    patterns.add(new SDatePattern(date));
    patterns.add(new SSDatePattern(date));

    patterns.add(new TDatePattern(date));
    patterns.add(new TTDatePattern(date));

    patterns.add(new YDatePattern(date));
    patterns.add(new YYDatePattern(date));
    patterns.add(new YYYDatePattern(date));
    patterns.add(new YYYYDatePattern(date));
    patterns.add(new YYYYYDatePattern(date));

    patterns.sort(new DatePatternComparator());
    return patterns;
  }

  /**
   * Serve for sorting list of pattern
   */
  private class DatePatternComparator implements java.util.Comparator<DatePattern> {
    @Override
    public int compare(DatePattern datePattern1, DatePattern datePattern2) {
      return datePattern1.compareTo(datePattern2);
    }
  }
}
