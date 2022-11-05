package ui;

import java.util.Scanner;

import model.Movie;

public class AdminMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;

    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * This method prints the options for admins after login
     * 
     */
    public void textDisplayUI() {
        System.out.println("**************************************************************************************************");
        System.out.println("1. Create Movie Listing.\n"
                + "2. Update/Remove Movie Listing.\n"
                + "3. Create Cinema Showtime.\n"
                + "4. Update/Remove Cinema Showtime.\n"
                + "5. Configure system settings.\n"
                + "6. Logout.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose an option from the menu:");
    }
    
    /*
     * This method uses textDisplayUI to print options and
     * process user input 
     * 
     */
    public void displayAdminUI() {
        int selection;
        
        // list out main menu selection UI
        this.textDisplayUI();
        selection = sc.nextInt();
        
        while (selection < 1 || selection > 6) {
            System.out.println("Please choose from the options\n");
            selection = sc.nextInt();
        }
        
        switch(selection){
            case 1:
                System.out.println("Enter movie title: ");
                String title = sc.next();
                Movie newMov = new Movie(title);
                
                System.out.println("Enter movie director: ");
                String director = sc.next();
                newMov.setDirector(director);
                
                System.out.println("Enter number of cast: ");
                int castSize = sc.nextInt();
                for (int i = 0; i < castSize; i++) {
                    System.out.println("Enter Cast " + i +": ");
                    newMov.addCast(sc.next()); 
                }
                
                System.out.println("Enter Synopsis: ");
                newMov.setSynopsis(sc.next());
                
                System.out.println("Enter movieStatus: ")
                break;
            case 2:
            
                break;
            case 3:
          
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                mC.appEnt.start();
                break;
        }     
    }
}








