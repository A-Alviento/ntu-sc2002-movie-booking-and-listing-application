package ui;

import java.time.LocalDate;
import java.util.Scanner;

import model.PublicHolidays;

/**
 * Serves as logic controller for admins 
 * to modify configuarations
 * 
 */
public class ConfigController {
    
    static Scanner sc = new Scanner(System.in);
    
    public boolean configEntry(int selection) {
        
        switch(selection) {
            case 1:
                this.updateTicketPrice();
                break;
            case 2:
                while(this.updateHolidays());
                break;
            case 3: 
                
                break;
            case 4:
                return false;
        }
        return true;
    }
    
    
    public void updateTicketPrice() {
        PriceModifierUI.display();
    }
    
    public boolean updateHolidays() {
        System.out.println("Select an option: ");
        System.out.println("1. Add Holiday");
        System.out.println("2. Remove Holiday");
        
        // exception
        int selection = sc.nextInt();
        sc.nextLine();
        
        switch(selection) {
            case 1:
                
                LocalDate newDate = DateTimeInputController.dateInput(CheckUserInput.loopUntilValidString("Enter a date (yyyy-mm-dd) : \n", 0));
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
                int holidayIndex = sc.nextInt();
                sc.nextLine();
                
                if (PublicHolidays.removePublicHoliday(PublicHolidays.getPublicHolidays().get(holidayIndex-1)) == 0) {
                    System.out.println("Entered date is not a holiday.");
                    return false;
                }
                System.out.println("Removed.");
                break;
                
        }
        
        return true;
    }
    
    public void updateSortAccess() {
        int isSale, isRating;
        
        System.out.print("Authorise access for users to sort by ticket sales? (1 - yes ; 0 - no): ");
        // exception
        isSale = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Authorise access for users to sort by movie rating? (1 - yes ; 0 - no): ");
        // exception
        isRating = sc.nextInt();
        sc.nextLine();
        
        if(isSale == 0)
            UserMenuUI.isSortRatings = false;
        else 
            UserMenuUI.isSortRatings = true;
        
        if(isRating == 0)
            UserMenuUI.isSortRatings = false;
        else
            UserMenuUI.isSortSales = true;
        
        
    }
    

}
