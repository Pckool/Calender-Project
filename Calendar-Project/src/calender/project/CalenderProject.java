package calender.project;
import java.util.*;
import java.time.*;
/**
 *
 * @author phill
 */
public class CalenderProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Creates a new Calendar
        ECalendar main_calendar = new ECalendar();
        boolean loop = true;
        while(loop){
            main_calendar.printCalendar();
            println("Would you like to add an event?");
            print("Yes/No: ");
            String var = in.next();
            var = var.toLowerCase();
            if(var.equals("yes")){
                
            }
            else if(var.equals("no")){
                loop = false;
            }
            else{
                println("You did not enter a correct value. Exiting the program...");
                loop = false;
            }
        }
        
    }
    public static void println(Object arg){
        System.out.println(arg);
    }
    
    public static void print(Object arg){
        System.out.print(arg);
    }
    
}
