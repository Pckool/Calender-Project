package calender.project;

import java.util.Calendar;

/**
 *
 * @author phill
 */
public interface EventInterface {
    public void setName(String name);
    public void setDescription(String desc);
    public void setCalendar(Calendar cal);
    public String DisplayEvent();
}
