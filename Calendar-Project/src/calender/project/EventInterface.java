/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
