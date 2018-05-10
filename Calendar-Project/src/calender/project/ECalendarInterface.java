package calender.project;

import java.util.Calendar;

/**
 *
 * @author phill
 */
public interface ECalendarInterface {
    public String getEvents(Calendar cal);
    public void setEvent(String name, String description, Calendar cal);
    public Calendar getCalendar();
    public boolean isLeapYear(int year);
    public boolean isLeapYear();
    public int day(int month, int day, int year);
    public void changeDate(int year, int month, int day);
    public void changeDate(int month, int day);
    public void changeDate(int day);
    public void displayCalendar();
}
