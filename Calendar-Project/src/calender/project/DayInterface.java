/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.project;

/**
 *
 * @author phill
 */
public interface DayInterface {
    /**
     * 
     * @param Event an Event object
     */
    public void addEvent(Event e);
    public void replaceEvent(Event e, int i);
        
    /**
     * 
     * @param i int: The index of the event you want to remove (starting at 1)
     */
    public void removeEvent(int i);
    
    /**
     * @return the EventHandler that this day is using
    */
    public EventHandler getEventHandler();
}
