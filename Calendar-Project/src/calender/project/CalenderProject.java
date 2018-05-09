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
            main_calendar.displayCalendar();
            println("Would you like to add an event?");
            print("Yes/No: ");
            String var = in.nextLine();
            var = var.toLowerCase();
            if(var.equals("yes")){
                String name;
                String description;
                int year;
                int month;
                int day;
                
                print("Event Name: ");
                name = in.nextLine();
                
                print("Event Description: ");
                description = in.nextLine();
                
                print("Is the event today?: ");
                String isToday = in.nextLine();
                
                if(isToday.toLowerCase().equals("yes")){
                    
                }
                else{
                    boolean setDate = true;
                    while(setDate){
                        setDate = false;
                        try{
                            print("Event Year: ");
                            year = in.nextInt();
                            print("Event Month: ");
                            month = in.nextInt();
                            print("Event Day: ");
                            day = in.nextInt();
                            // Changes the date to the specified amount
                            main_calendar.changeDate(year, month, day);
                        }catch(InputMismatchException e){
                            println("You need to give an integer to represent "
                                    + "any of the date values.");
                            setDate = true;
                        }
                    }   
                }
                main_calendar.setEvent(name, description, main_calendar.getCalendar());
                
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
