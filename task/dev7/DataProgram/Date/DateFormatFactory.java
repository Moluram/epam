package com.moluram.task.dev7.DataProgram.Date;

import com.moluram.task.dev7.DataProgram.Date.Patterns.DatePattern;
import com.moluram.task.dev7.DataProgram.Date.Patterns.HHFullDatePattern;
import com.moluram.task.dev7.DataProgram.Date.Patterns.MMMinutesDatePattern;
import com.moluram.task.dev7.DataProgram.Date.Patterns.SSDatePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Class serve for creating DateFormat object
 */
public class  DateFormatFactory {
  /**
   * Creates DateFormat object
   * @return DateFormat - new DateFormat object
   */
  public DateFormat getDateFormatObject() {
    List<DatePattern> list = new ArrayList<>();
    list.add(new HHFullDatePattern());
    list.add(new MMMinutesDatePattern());
    list.add(new SSDatePattern());
    return new DateFormat(list);
  }
}
