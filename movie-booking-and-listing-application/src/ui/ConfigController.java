package ui;

import java.util.Scanner;

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
        
    }
    
    public void updateSortAccess() {
        
    }
    

}
