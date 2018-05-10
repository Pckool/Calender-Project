package calender.project;

import java.util.Calendar;

/**
 *
 * @author phill
 */
public interface EventInterface {
    /**
    * @param name A String of the name of your Event
    * @return None
    */
    public void setName(String name);
    /**
    * @param String a String of the description of your event
    * @return None
    */
    public void setDescription(String desc);
    /**
    * @param Calendar a Calendar Object
    * @return None
    */
    public void setCalendar(Calendar cal);
    /**
    * @param None
    * @return A string of the event
    */
    public String DisplayEvent();
}
