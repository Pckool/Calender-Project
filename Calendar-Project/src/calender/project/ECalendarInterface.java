package calender.project;

import java.util.Calendar;

/**
 *
 * @author phill
 */
public interface ECalendarInterface {
    /**
     * @param Calendar a Clanedar object
     * @return String: a formatted string with every event for the given day of the calendar
    */
    public String getEvents(Calendar cal);
    /**
     * 
     * @param name
     * @param description a String of the description of your event
     * @param calendar a Clanedar object
     */
    public void setEvent(String name, String description, Calendar cal);
    /**
     * 
     * @return Calendar
     */
    public Calendar getCalendar();
    /**
     * 
     * @param year
     * @return boolean
     */
    public boolean isLeapYear(int year);
    /**
     * 
     * @return boolean
     */
    public boolean isLeapYear();
    /**
     * 
     * @param year  int: the year
     * @param month int: the day of the month
     * @param day   int: the day of the month
     * @return integer
     */
    public int day(int year, int month, int day);
    /**
     * 
     * @param year  int: the year
     * @param month int: the day of the month
     * @param day   int: the day of the month
     */
    public void changeDate(int year, int month, int day);
     /**
     * 
     * @param month int: the day of the month
     * @param day   int: the day of the month
     */
    public void changeDate(int month, int day);
    /**
     * 
     * @param day int: the day of the month
     */
    public void changeDate(int day);
    /**
     * This displays the calendar properly
     */
    public void displayCalendar();
}
