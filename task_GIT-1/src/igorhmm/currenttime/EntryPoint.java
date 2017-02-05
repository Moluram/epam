package igorhmm.currenttime;

/**
 * Entry point to software to get current time,
 * No input parameters from CL are used
 */
public class EntryPoint {
  public static final String TIME_FORMAT = "HH:mm";
  public static final String STRING_CURRENT_TIME_IS = "Current time is ";

  /**
   * Starts execution of the program
   */
  public static void main(String[] args) {
    System.out.println(STRING_CURRENT_TIME_IS + CurrentTime.getTime(TIME_FORMAT));
  }
}