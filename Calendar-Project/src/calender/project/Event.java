
package calender.project;
import java.time.*;
import java.util.*;
/**
 *
 * @author phill
 */
public class Event implements EventInterface{
    public Calendar CALENDAR;
    public int YEAR;
    public int MONTH;
    public int DATE;

    Event(String name, String description, Calendar c){
        CALENDAR = c;
        YEAR = CALENDAR.get(Calendar.YEAR);
        MONTH = CALENDAR.get(Calendar.MONTH);
        DATE = CALENDAR.get(Calendar.DATE);
    }
    
    public void setDetails(String name){
        
    }
}
