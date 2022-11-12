package ui;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Serves as logic controller for admins to modify configurations.
 */
public class ConfigController {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public ConfigController(MainController mC) {
        this.mC = mC;
    }
    
    public boolean configEntry(int selection) {
        
        switch(selection) {
            case 1:
                this.updateTicketPrice();
                break;
            case 2:
                while(this.updateHolidays());
                break;
            case 3: 
                this.updateSortAccess();
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
        System.out.println("3. Back");
        
        // exception
        int selection = sc.nextInt();
        sc.nextLine();
        
        switch(selection) {
            case 1:
                
                LocalDate newDate = DateTimeInputController.dateInput(CheckUserInput.loopUntilValidString("Enter a date (yyyy-mm-dd) : \n", 0));
                mC.publicHolidays.addPublicHoliday(newDate);
                System.out.println("Holiday added successfully");
                break;
                
            case 2:
                int size = mC.publicHolidays.getPublicHolidays().size();
                if (size == 0) {
                    System.out.println("No holidays.");
                    break;
                }
                
                System.out.println("List of Holidays: ");
                for (int i = 1; i <= size; i++) {
                    System.out.println(i + ". " + mC.publicHolidays.getPublicHolidays().get(i-1));
                }
                System.out.print("Select the date you wish to remove by entering it's number: ");
                // exception
                int holidayIndex = sc.nextInt();
                sc.nextLine();
                
                if (mC.publicHolidays.removePublicHoliday(mC.publicHolidays.getPublicHolidays().get(holidayIndex-1)) == 0) {
                    System.out.println("Entered date is not a holiday.");
                    return false;
                }
                System.out.println("Removed.");
                break;
            case 3:
                return false;
                
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
            UserMenuUI.isSortSales = false;
        else
            UserMenuUI.isSortSales = true;
        
        
    }
    

}
