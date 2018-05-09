package calender.project;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author phill
 * @description This is basically a wrapper class for the more complicated Calendar class given with java.util
 */
public class ECalendar {
// GLOBAL VARIABLES
    private static Calendar CALENDAR;
    private static EventHandler[] EHDLR = new EventHandler[12];
    
// CONSTRUCTORS
    ECalendar(){
        CALENDAR = new GregorianCalendar();
    }
    ECalendar(Date date){
        CALENDAR = new GregorianCalendar();
    }
    
// EVENT METHODS
    public String getEvents(Calendar cal){
        EHDLR[cal.get(Calendar.MONTH)].getEvents();
        
        return "";
    }
    public void setEvent(String name, String description, Calendar cal){
        EHDLR[cal.get(Calendar.MONTH)].addEvent(name, description, cal);
        
        String event = "";
        
    }
    
// CALENDAR METHODS
    public Calendar getCalendar(){
        return CALENDAR;
    }
    
    // return true if the given year is a leap year
    public boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) 
            return true;
        if  (year % 400 == 0) 
            return true;
        return false;
    }
    public boolean isLeapYear() {
        if  ((CALENDAR.getWeekYear() % 4 == 0) && (CALENDAR.getWeekYear() % 100 != 0)) 
            return true;
        if  (CALENDAR.getWeekYear() % 400 == 0) 
            return true;
        return false;
    }
    
    public int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }
    
    public void changeDate(int year, int month, int day){
        CALENDAR.set(Calendar.YEAR, year);
        CALENDAR.set(Calendar.MONTH, month);
        CALENDAR.set(Calendar.DATE, day);
    }
    public void changeDate(int month, int day){
        if (day > 0 && day <= 31){
            CALENDAR.set(Calendar.MONTH, month);
            CALENDAR.set(Calendar.DATE, day);
        }
        
    }
    public void changeDate(int day){
        if (day > 0 && day <= 31){
            CALENDAR.set(Calendar.DATE, day);
        }
    }
    
    public static void displayCalendar() {
        int Y = CALENDAR.get(Calendar.YEAR);    // year
        int startDayOfMonth = CALENDAR.get(Calendar.DAY_OF_MONTH);
        int spaces = startDayOfMonth;

        // months[i] = name of month i
        String[] months = {
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
            };

            // days[i] = number of days in month i
            int[] days = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            };

            for (int i = 0; i < 12; i++) {

            // check for leap year
            if  ((((Y % 4 == 0) && (Y % 100 != 0)) ||  (Y % 400 == 0)) && i == 2)
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
                if (((ii + spaces) % 7 == 0) || (ii == days[i])) System.out.println();
            }

            System.out.println();
        }
    }      
}
