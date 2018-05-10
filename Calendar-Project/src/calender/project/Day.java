package calender.project;
import java.util.*;
/**
 *
 * @author phill
 * @description This is basically a container for a EventHandler
 */
public class Day extends LinkedList implements DayInterface{
    // GLOBAL VARIABLES
    private EventHandler EHANDLER;
    
    public Month MonthOBJ;
    
    // CONSTRUCTOR
    /**
     * @param EventHandler
     * @return None
    */
    Day(){
        this.EHANDLER = new EventHandler();
    }
    Day(Month mon){
        MonthOBJ = mon;
        this.EHANDLER = new EventHandler(MonthOBJ, this);
    }
    
    @Override
    public void addEvent(Event e){
        this.EHANDLER.addEvent(e);
    }
    @Override
    public void replaceEvent(Event e, int i){
        removeEvent(i);
        addEvent(e);
    }
    public void removeEvent(int i){
        
    }
    
    @Override
    public EventHandler getEventHandler(){
        return EHANDLER;
    }
}
