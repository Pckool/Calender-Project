package calender.project;
import java.util.*;

/**
 *
 * @author phill
 * @description This is basically a container for 'days'
 */
public class Month {
    protected List<Day> DAYS;
    public int MONTH_VAL;
    
    Month(int days, int monthVal){
        DAYS = new ArrayList<>();
        MONTH_VAL = monthVal;
        for(int x = 0; x<days; x++){
            DAYS.add(new Day(new EventHandler()));
        }
    }
    
    /**
     * 
     * @param date An integer of the date (1-31 please)
     * @return 
     */
    public Day getDay(int x){
        System.out.println(MONTH_VAL);
        return DAYS.get(x);
    }
    
}
