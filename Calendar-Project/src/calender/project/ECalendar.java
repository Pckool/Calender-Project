package calender.project;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author phill
 * @description This is basically a wrapper class for the more complicated Calendar class given with java.util
 */
public class ECalendar implements ECalendarInterface{
// GLOBAL VARIABLES
    private static Calendar CALENDAR;
    private static List<Month> MONTHS = new ArrayList<>();
    // months[i] = name of month i
    protected String[] months = {
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    };

    // days[i] = number of days in month i
    protected int[] days = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    
// CONSTRUCTORS
    ECalendar(){
        this.CALENDAR = new GregorianCalendar();
        int year = this.CALENDAR.get(Calendar.YEAR);
        for (int x = 0; x < 12; x++) {
            // check for leap year
            if  (isLeapYear(year))
                days[x] = 29;
            MONTHS.add(new Month(days[x]));
        }
    }
    
// EVENT METHODS
    /**
     * @param Calendar
     * @return String: a formatted string with every event for the given day of the calendar
    */
    public String getEvents(Calendar cal){
        // This long line returns a string of all the events on the day of the given calendar
        MONTHS.get(cal.get(Calendar.MONTH)).getDay(cal.get(Calendar.DATE)).getEventHandler().getEvents();
        return "";
    }
    /**
     * 
     * @param name
     * @param description
     * @param calendar 
     */
    public void setEvent(String name, String description, Calendar cal){
        MONTHS.get(cal.get(Calendar.MONTH)).getDay(cal.get(Calendar.DATE)).getEventHandler().addEvent(name, description, cal);
    }
    
// CALENDAR METHODS
    /**
     * 
     * @return Calendar
     */
    public Calendar getCalendar(){
        return this.CALENDAR;
    }
    
    // return true if the given year is a leap year
    /**
     * 
     * @param year
     * @return 
     */
    public boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) 
            return true;
        if  (year % 400 == 0) 
            return true;
        return false;
    }
    /**
     * 
     * @return 
     */
    public boolean isLeapYear() {
        if  ((this.CALENDAR.getWeekYear() % 4 == 0) && (this.CALENDAR.getWeekYear() % 100 != 0)) 
            return true;
        if  (this.CALENDAR.getWeekYear() % 400 == 0) 
            return true;
        return false;
    }
    
    /**
     * 
     * @param month
     * @param day
     * @param year
     * @return 
     */
    public int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }
    
    /**
     * 
     * @param year
     * @param month
     * @param day 
     */
    public void changeDate(int year, int month, int day){
        this.CALENDAR.set(Calendar.YEAR, year);
        this.CALENDAR.set(Calendar.MONTH, month);
        this.CALENDAR.set(Calendar.DATE, day);
    }
    /**
     * 
     * @param month
     * @param day 
     */
    public void changeDate(int month, int day){
        if (day > 0 && day <= 31){
            this.CALENDAR.set(Calendar.MONTH, month);
            this.CALENDAR.set(Calendar.DATE, day);
        }
        
    }
    /**
     * 
     * @param day 
     */
    public void changeDate(int day){
        if (day > 0 && day <= 31){
            this.CALENDAR.set(Calendar.DATE, day);
        }
    }
    
    /**
     * 
     */
    public void displayCalendar() {
        int Y = this.CALENDAR.get(Calendar.YEAR);    // year
        int startDayOfMonth = this.CALENDAR.get(Calendar.DAY_OF_MONTH);
        int spaces = startDayOfMonth;
        for (int i = 0; i < 12; i++) {

            // check for leap year
            if  (isLeapYear(Y))
                days[i] = 29;


            // print calendar header
            // Display the month and year
            System.out.println("          "+ months[i] + " " + Y);

            // Display the lines
            System.out.println("_____________________________________");
            System.out.println("   Sun  Mon Tue   Wed Thu   Fri  Sat");

            // spaces required
               spaces = (days[i] + spaces)%7;

            // print the calendar
            for (int ii = 0; ii < spaces; ii++)
                System.out.print("     ");
            for (int ii = 1; ii <= days[i]; ii++) {
                System.out.printf(" %3d ", ii);
                if (((ii + spaces) % 7 == 0) || (ii == days[i])) 
                    System.out.println();
            }

            System.out.println();
        }
    }      
}
