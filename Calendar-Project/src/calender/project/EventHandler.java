package calender.project;

import java.util.Calendar;
import java.util.*;

/**
 *
 * @author phill
 */
public class EventHandler {
    protected static List<Event> EVENT_LIST = new LinkedList<>();
    EventHandler(){
        
    }
    /**
     * 
     * @param name
     * @param description
     * @param calendar
     */
    public void addEvent(String name, String description, Calendar cal){
        EventInterface evnt = new Event(name, description, cal);
        
    }
    /**
     * 
     * @param event
     */
    public void addEvent(Event e){
        EVENT_LIST.add(e);
        
    }
    /**
     * 
     */
    public void getEvents(){
        
    }
    
}
