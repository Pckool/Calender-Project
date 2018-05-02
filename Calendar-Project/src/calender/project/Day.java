/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender.project;
import java.util.*;
/**
 *
 * @author phill
 */
public class Day extends LinkedList{
    // GLOBAL VARIABLES
    protected static List EVENT_LIST = new LinkedList();
    
    Day(){
        
    }
    public void addEvent(Event e){
        EVENT_LIST.add(e);
    }
    public void replaceEvent(Event e, int i){
        EVENT_LIST.get(i);
    }
    public void removeEvent(Event e){
        
    }
}
