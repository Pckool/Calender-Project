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
        ECalendarInterface main_calendar = new ECalendar();
        boolean loop = true;
        main_calendar.displayCalendar();
        while(loop){
            
            println("1: Add an event?");
            println("2: View today's events");
            println("3: Change the date");
            println("0: Exit");
            int var = in.nextInt();
            
            switch (var) {
                case 1:
                    String name;
                    String description;
                    int year;
                    int month;
                    int day;
                    print("Event Name: ");
                    in.nextLine();
                    name = in.nextLine();
                    print("Event Description: ");
                    description = in.next();
                    in.nextLine();
                    println("Is the event today?: ");
                    println("1: Yes");
                    println("0: No");
                    int isToday = in.nextInt();
                    
                    if(isToday == 1){
                        
                    }
                    else{
                        boolean setDate = true;
                        while(setDate){
                            setDate = false;
                            try{
                                print("Event Year: ");
                                year = in.nextInt();
                                print("Event Month: ");
                                month = in.nextInt() - 1;
                                print("Event Day: ");
                                day = in.nextInt();
                                // Changes the date to the specified amount
                                main_calendar.changeDate(year, month, day);
                            }catch(InputMismatchException e){
                                println("You need to give an integer to represent "
                                        + "any of the date values.\n ERROR: " + e);
                                setDate = true;
                                continue;
                            }
                        }
                    }   main_calendar.setEvent(name, description, main_calendar.getCalendar());
                    break;
                case 2:
                    // OUTPUT TODAY'S EVENTS
                    println(main_calendar.getEvents(main_calendar.getCalendar()));
                    print("Press enter to continue...");
                    in.nextLine();
                    in.nextLine();
                    println("");
                    break;
                case 3:
                    // SET THE DATE
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
                                    + "any of the date values. \n ERROR: " + e);
                            setDate = true;
                            continue;
                        }
                    }
                    break;
                case 4:
                    
                    
                    print("Press enter to continue...");
                    in.nextLine();
                    in.nextLine();
                    println("");
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    println("You did not enter a correct value. Exiting the program...");
                    loop = false;
                    break;
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
