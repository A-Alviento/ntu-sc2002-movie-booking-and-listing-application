package ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Serves as the class to take input of date and time 
 * from user as string and process it to a LocalDate/LocalTime.
 * 
 */
public class DateTimeInputController {
    private static Scanner sc = new Scanner(System.in);
    
    public static LocalDate dateInput(String userInput) {
            while(true) {
                try {
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(userInput, dateFormat);
                    System.out.println(date);
                    return date ;
                }catch(DateTimeParseException e) {
                    System.out.println("You did not input the correct pattern, try again: ");
                    userInput = sc.nextLine();
                }
            }
            
        }
    
    public static LocalTime timeInput(String userInput) {
            while(true) {
                try {
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime time = LocalTime.parse(userInput, dateFormat);
                    System.out.println(time);
                    return time ;
                }catch(DateTimeParseException e) {
                    System.out.println("You did not input the correct pattern, try again: ");
                    userInput = sc.nextLine();
                }
            }
            
            
           
        }

}
