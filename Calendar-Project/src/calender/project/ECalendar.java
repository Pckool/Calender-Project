package calender.project;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author phill
 * @description This is basically a wrapper class for the more complicated Calendar class given with java.util
 * It's use is not intuative. First you must instantiate a new ECalendar (this).
 * Then in order to pass in the calendar it creates, you must use the getCalendar 
 * method and pass that in. I know... Weird but it works quite well.
 * This class is like a smokescreen for the more complicated Calendar class.
 * 
 * @see README in root directory
 */
public class ECalendar implements ECalendarInterface{
// GLOBAL VARIABLES
    private static Calendar CALENDAR;
    private static List<Month> MONTHS ;
    
    // months[i] = name of month i
    private String[] months = {
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    };

    // days[i] = number of days in month i
    private int[] days = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    
// CONSTRUCTORS
    ECalendar(){
        MONTHS = new ArrayList<>();
        CALENDAR = new GregorianCalendar();
        int year = CALENDAR.get(Calendar.YEAR);
        for (int x = 0; x < 12; x++) {
            // check for leap year
            if(isLeapYear(year))
                days[x] = 29;
            MONTHS.add(new Month(days[x], x));
        }
    }
    
// EVENT METHODS
    @Override
    public String getEvents(Calendar cal){
        // This long line returns a string of all the events on the day of the given calendar
        System.out.println("ECAL");
        return MONTHS.get(cal.get(Calendar.MONTH)).getDay(cal.get(Calendar.DATE)).getEventHandler().getEvents(); 
    }
    @Override
    public void setEvent(String name, String description, Calendar cal){
        MONTHS.get(cal.get(Calendar.MONTH)).getDay(cal.get(Calendar.DATE)).getEventHandler().addEvent(name, description, cal);
    }
    
// CALENDAR METHODS
    @Override
    public Calendar getCalendar(){
        return CALENDAR;
    }
    
    // return true if the given year is a leap year
    @Override
    public boolean isLeapYear(int year) {
        if((year % 4 == 0) && (year % 100 != 0)) 
            return true;
        if(year % 400 == 0) 
            return true;
        return false;
    }
    @Override
    public boolean isLeapYear() {
        if((CALENDAR.getWeekYear() % 4 == 0) && (CALENDAR.getWeekYear() % 100 != 0)) 
            return true;
        if(CALENDAR.getWeekYear() % 400 == 0) 
            return true;
        return false;
    }
    
    @Override
    public int day(int year, int month, int day) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }
    
    @Override
    public void changeDate(int year, int month, int day){
        CALENDAR.set(Calendar.YEAR, year);
        CALENDAR.set(Calendar.MONTH, month);
        CALENDAR.set(Calendar.DATE, day);

    }
    @Override
    public void changeDate(int month, int day){
        if (day > 0 && day <= 31){
            CALENDAR.set(Calendar.MONTH, month);
            CALENDAR.set(Calendar.DATE, day);
        }
        
    }
    @Override
    public void changeDate(int day){
        if (day > 0 && day <= 31){
            CALENDAR.set(Calendar.DATE, day);
        }
    }
    
    @Override
    public void displayCalendar() {
        int Y = CALENDAR.get(Calendar.YEAR);    // year
        int startDayOfMonth = CALENDAR.get(Calendar.DAY_OF_MONTH);
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
