package ui;

import java.util.ArrayList;

import model.CustomerAccount;

/*
 * This represents the main logic coordinator of the UI subclasses
 * It coordinates the different UI classes and presents them in the form of
 * text-based UI for the user;
 * 
 */

public class MainController {
 
    protected AppEntry appEnt;
    protected CineplexUI cineplex;
    
    private AdminMenuUI admin;
    private UserMenuUI user;
    private MovieUI movie;
    
    private ArrayList<CustomerAccount> cusAcc;
    
    public MainController() {
        
        cineplex.setMainController(this);
        admin.setMainController(this);
        user.setMainController(this);
        movie.setMainController(this);
        
        // stores list of accounts
        cusAcc = new ArrayList<>();
    }
    
    /*
     * take in user input for LoginUI
     * 
     */
    public int login(int selection) {
        
        switch(selection){
            case 1:
                // login class
                
                cineplex.displayCineplexUI();
                user.displayMainUI();
                
                
                return 1;
            case 2:
                CustomerAccount c = new CustomerAccount();
                c.createAccount();
                cusAcc.add(c);
                System.out.println("Account created");
                appEnt.start();
                
                return 1;
            case 3:
                // login class
                
                admin.displayAdminUI();
                return 1;
            case 4:
                appEnt.stop();
                return 1;
        }
        
        return -1;
    }

    
    /*
     * allow appEntry to terminate app
     * 
     */
    public void setObject(AppEntry appEnt) {
        
        this.appEnt = appEnt; 
    }
    
}
