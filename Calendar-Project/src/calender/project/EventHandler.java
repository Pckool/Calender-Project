package calender.project;

import java.util.Calendar;
import java.util.*;

/**
 *
 * @author phill
 */
public class EventHandler {
    public Month MonthOBJ;
    public Day DayOBJ;
    
    protected static List<Event> EVENT_LIST;
    EventHandler(){
        EVENT_LIST = new LinkedList<>();
        
    }
    EventHandler(Month mon, Day day){
        EVENT_LIST = new LinkedList<>();
        MonthOBJ = mon;
        DayOBJ = day;
    }
    /**
     * 
     * @param name
     * @param description a String of the description of your event
     * @param calendar a Clanedar object
     */
    public void addEvent(String name, String description, Calendar cal){
        EventInterface evnt = new Event(name, description, cal, MonthOBJ, DayOBJ, this);
        EVENT_LIST.add((Event)evnt);
        
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
        System.out.println("EHANDLER");
        String events = "";
        if(EVENT_LIST.isEmpty()){
            events = "There are no events on this day.";
        }
        else{
            for(int x = 0; x < EVENT_LIST.size(); x++){
                events = events + "=================================================\n";
                events += EVENT_LIST.get(x).DisplayEvent() + "\n"; 
            }
            
        }
        System.out.println(EVENT_LIST.size());
        return events;
    }
    
}
