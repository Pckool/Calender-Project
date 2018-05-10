package calender.project;
import java.time.*;
import java.util.*;
/**
 *
 * @author phill
 * @description This is the event class. The core of an event
 */
public class Event implements EventInterface{
    public Calendar CALENDAR;
    public int YEAR;
    public int MONTH;
    public int DAY;
    public int HOUR;
    public int MINUTE;
    public int AM_PM;
    public String NAME;
    public String DESCRIPTION;
    
    private int NUMBER;
    Event(String name, String description, Calendar c){
        CALENDAR = c;
        YEAR = CALENDAR.get(Calendar.YEAR);
        MONTH = CALENDAR.get(Calendar.MONTH);
        DAY = CALENDAR.get(Calendar.DATE);
        HOUR = CALENDAR.get(Calendar.HOUR);
        MINUTE = CALENDAR.get(Calendar.MINUTE);
        AM_PM = CALENDAR.get(Calendar.AM_PM);
        DESCRIPTION = description;
        NAME = name;
    }
    
    @Override
    /**
    * @param name A String of the name of your Event
    * @return None
    */
    public void setName(String name){
        NAME = name;
    }
    
    @Override
    /**
    * @param String a String of the description of your event
    * @return None
    */
    public void setDescription(String desc){
        DESCRIPTION = desc;
    }
    
    @Override
    /**
    * @param Calendar a Calendar Object
    * @return None
    */
    public void setCalendar(Calendar cal){
        CALENDAR = cal;
        YEAR = CALENDAR.get(Calendar.YEAR);
        MONTH = CALENDAR.get(Calendar.MONTH);
        DAY = CALENDAR.get(Calendar.DATE);
        
    }
    /**
    * @param None
    * @return A string of the event
    */
    public String DisplayEvent(){
        return "Name: " + this.NAME + "\n" +
               "Description: " + this.DESCRIPTION + "\n" +
               "Date: " + this.MONTH + "/" + this.DAY + "/" + this.YEAR + "\n" +
               "Date: " + this.HOUR + ":" + this.MINUTE + this.AM_PM
                ;
    }
}
