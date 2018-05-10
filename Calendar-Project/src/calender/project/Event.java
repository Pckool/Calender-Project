package calender.project;
import java.time.*;
import java.util.*;
/**
 *
 * @author phill
 * @description This is the event class. The core of an event
 */
public class Event implements EventInterface{
    private Calendar CALENDAR;
    private int YEAR;
    private int MONTH;
    private int DAY;
    private int HOUR;
    private int MINUTE;
    private int AM_PM;
    private String NAME;
    private String DESCRIPTION;
    
    private static int EVENTCOUNT;
    
    private int NUMBER;
    
    Event(String name, String description, Calendar c){
        EVENTCOUNT++;
        CALENDAR = c;
        YEAR = CALENDAR.get(Calendar.YEAR);
        MONTH = CALENDAR.get(Calendar.MONTH);
        DAY = CALENDAR.get(Calendar.DATE);
        HOUR = CALENDAR.get(Calendar.HOUR);
        MINUTE = CALENDAR.get(Calendar.MINUTE);
        AM_PM = CALENDAR.get(Calendar.AM_PM);
        DESCRIPTION = description;
        NAME = name;
        System.out.println(EVENTCOUNT);
        System.out.println(YEAR);
        System.out.println(MONTH);
        System.out.println(DAY);
        System.out.println(NAME);
        System.out.println(DESCRIPTION);
    }
    
    @Override
    public void setName(String name){
        NAME = name;
    }
    
    @Override
    public void setDescription(String desc){
        DESCRIPTION = desc;
    }
    
    @Override
    public void setCalendar(Calendar cal){
        CALENDAR = cal;
        YEAR = CALENDAR.get(Calendar.YEAR);
        MONTH = CALENDAR.get(Calendar.MONTH);
        DAY = CALENDAR.get(Calendar.DATE);
        
    }
    @Override
    public String DisplayEvent(){
        return "Name: " + this.NAME + "\n" +
               "Description: " + this.DESCRIPTION + "\n" +
               "Date: " + this.MONTH + "/" + this.DAY + "/" + this.YEAR + "\n" +
               "Date: " + this.HOUR + ":" + this.MINUTE + this.AM_PM
                ;
    }
    
    @Override
    public void finalize(){
        EVENTCOUNT = EVENTCOUNT-1;
        try{
            super.finalize();
        }
        catch(Throwable e){
            System.out.println(e);
        }
    }
}
