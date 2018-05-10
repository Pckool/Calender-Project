package calender.project;

import java.util.Calendar;
import java.util.*;

/**
 *
 * @author phill
 */
public class EventHandler {
    protected static List<Event> EVENT_LIST;
    EventHandler(){
        EVENT_LIST = new LinkedList<>();
    }
    /**
     * 
     * @param name
     * @param description a String of the description of your event
     * @param calendar a Clanedar object
     */
    public void addEvent(String name, String description, Calendar cal){
        EventInterface evnt = new Event(name, description, cal);
        
    }
    /**
     * 
     * @param event an Event object
     */
    public void addEvent(Event e){
        EVENT_LIST.add(e);
        
    }
    /**
     * 
     */
    public String getEvents(){
        String events = "";
        if(EVENT_LIST.size() > 0){
            for(int x = 0; x < EVENT_LIST.size(); x++){
                events += "=================================================";
                events += EVENT_LIST.get(x).DisplayEvent() + "\n"; 
            }
        }
        else{
            events = "There are no events on this day.";
        }
        
        return events;
    }
    
}
