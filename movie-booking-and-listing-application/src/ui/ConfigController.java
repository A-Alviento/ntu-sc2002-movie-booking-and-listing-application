package ui;

import java.time.LocalDate;
import java.util.Scanner;

import model.PublicHolidays;

public class ConfigController {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public ConfigController(MainController mC, int selection) {
        
        this.mC = mC;
        switch(selection) {
            case 1:
            case 2:
            case 3:
            case 4:
        }
    }
    
    public void updateTicketPrice() {
        PriceModifierUI.display();
    }
    
    public void updateHolidays() {
        System.out.println("Select an option: ");
        System.out.println("1. Add Holiday");
        System.out.println("2. Remove Holiday");
        
        // exception
        int selection = sc.nextInt();
        switch(selection) {
            case 1:
                LocalDate newDate = DateTimeInputController.dateInput("Enter a date (yyyy-mm-dd) : ");
                PublicHolidays.addPublicHoliday(newDate);
                System.out.println("Holiday added successfully");
                
                break;
                
            case 2:
                int size = PublicHolidays.getPublicHolidays().size();
                
                System.out.println("List of Holidays: ");
                for (int i = 1; i <= size; i++) {
                    System.out.println(i + ". " + PublicHolidays.getPublicHolidays().get(i));
                }
                System.out.print("Select the date you wish to remove by entering it's number: ");
                // exception
                
        }
        
    }
    
    public void updateSortAccess() {
        
    }
    

}
