package igorhmm.currenttime;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class to determine current system time
 */
public class CurrentTime {
  /**
   * Returns current system time in given format
   * @param  timeFormat Desirable format for current time output
   * @return current time
   */
  public static String getTime (String timeFormat) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
    return sdf.format(cal.getTime());
  }
}
package igorhmm.currenttime;

/**
 * Entry point to software to get current time,
 * No input parameters from CL are used
 */
public class EntryPoint {
  public static void main (String[] args) {
    System.out.println("Current time is " + CurrentTime.getTime("HH:mm"));
  }
}