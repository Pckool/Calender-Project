package calender.project;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author phill
 */
public class ECalendar {
// GLOBAL VARIABLES
    private static Calendar CALENDAR;
    
// CONSTRUCTORS
    ECalendar(){
        CALENDAR = new GregorianCalendar();
    }
    ECalendar(Date date){
        CALENDAR = new GregorianCalendar();
    }
    
// EVENT METHODS
    public String getEvent(){
        String event = "";
        
        return event;
    }
    public void setEvent(String name, String description){
        Event e = new Event(name, description, CALENDAR);
        
        String event = "";
        
    }
    
// CALENDAR METHODS
    
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
    
    public void printCalendar(){
        int month = CALENDAR.get(Calendar.MONTH);
        int year = CALENDAR.get(Calendar.YEAR);
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

        // check for leap year
        if (month == 2 && isLeapYear(year)) 
            days[month] = 29;


        // print calendar header
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");

        // starting day
        int d = day(month, 1, year);

        // print the calendar
        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
        }
        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
//        System.out.println(sdf.format(CALENDAR.getTime()));

    } 
}
