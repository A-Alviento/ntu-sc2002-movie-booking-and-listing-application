package ui;

import java.util.Scanner;

public class CineplexUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private int cineplexChoice;
    
    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    public void displayCineplexUI() {
        int selection;
        
        // list out main menu selection UI
        System.out.println("**************************************************************************************************");
        System.out.println("1. Cineplex 1\n"
                + "2. Cineplex 2\n"
                + "3. Cineplex 3\n"
                + "4. Back.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose a cineplex");
        selection = sc.nextInt();
        
        while (selection < 1 || selection > 4) {
            System.out.println("Please choose from the options\n");
            selection = sc.nextInt();
        }
        
        switch(selection){
            case 1:
                cineplexChoice = selection;
                break;
            case 2:
                cineplexChoice = selection;
                break;
            case 3:
                cineplexChoice = selection;
                break;
            case 4:
                mC.appEnt.start();
                break;
        }        
    }
    
    public int getCineplex() {
        return cineplexChoice;
    }
    
    
}