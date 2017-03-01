package com.moluram.task.dev7.DataProgram.Date;

import com.moluram.task.dev7.DataProgram.Date.Patterns.DatePattern;

import java.util.List;

/**
 * Class represent a format for inputting date.
 * The order of date patterns in datePatternsList represent the order of elements in a format.
 */
public class DateFormat {
  /**
   * Date pattern in format
   */
  private final List<DatePattern> datePatternsList;

  DateFormat(List<DatePattern> datePatternsList) {
    this.datePatternsList = datePatternsList;
  }

  /**
   * Checks whether the given string array represent this format
   * @param lineParts - line parts which represent the date patterns in this format
   * @return boolean - answer
   */
  public boolean isValidLine(String[] lineParts) {
    if (datePatternsList.size() != lineParts.length) {
      return false;
    }
    boolean answer = true;
    for (int i = 0; i < datePatternsList.size(); i++) {
      if (!datePatternsList.get(i).isSupport(lineParts[i])) {
        answer = false;
        break;
      }
    }
    return answer;
  }

  /**
   * Returns the view of this format (e.g. hh:mm:ss)
   * @param separator - separator to use in the view (e.g. ':' in upper example)
   * @return String - view (description)
   */
  public String getDescriptionWithSeparator(Character separator) {
    StringBuilder description = new StringBuilder();
    for (DatePattern pattern: datePatternsList) {
      description.append(pattern.getPattern()).append(separator);
    }
    return description.deleteCharAt(description.length() - 1).toString();
  }
}
