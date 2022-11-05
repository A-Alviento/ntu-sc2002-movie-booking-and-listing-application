package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;

/*
 * This represents the main logic coordinator of the UI subclasses
 * It coordinates the different UI classes and presents them in the form of
 * text-based UI for the user;
 * 
 */

public class MainController {
    
    static Scanner sc = new Scanner(System.in);
 
    // appEntry class
    protected AppEntry appEnt;
    
    // UI Components
    protected CineplexUI cineplex;
    private AdminMenuUI admin;
    protected UserMenuUI user;
    private MovieUI movie;
    
    // Cinema related classes
    private ArrayList<CustomerAccount> cusAcc;
    protected Cineplexes cinPlex;
    protected CustomerAccount currAcc;
    protected Movie currMov;
     
    // to do -> private ArrayList <Movie> mov; need to extract data from binary file
    // then store in an array;
      
    
    public MainController() {
        
        cineplex.setMainController(this);
        admin.setMainController(this);
        user.setMainController(this);
        movie.setMainController(this);
        
        // stores list of accounts
        cusAcc = new ArrayList<>();
        
        cinPlex = new Cineplexes();
        
        // stores list of movie
        // mov = new ArrayList<>();
    }
    
    /*
     * TODO
     * function to take movie data from database and insert
     * to mov arraylist
     * 
     */
    
    /*
     * take in user input for LoginUI
     * 
     */
    public int login(int selection) {
        boolean auth = false;
        switch(selection){
            case 1:
                // authenticates user account
                while(!auth)
                    auth = this.authenticateUserAccount();
                auth = false;
                
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
                // authenticates admin account
                while(!auth)
                    auth = this.authenticateAdminAccount();
                auth = false;
                
                admin.displayAdminUI();
                return 1;
            case 4:
                appEnt.stop();
                return 1;
        }
        
        return -1;
    }
    
    public boolean authenticateUserAccount() {
        System.out.println("Enter Email: ");
        String userID = sc.next();
        System.out.println("Enter Password: ");
        String userPass = sc.next();
        
        int len = cusAcc.size();
        
        for (int i = 0; i < len; i++) {
            if (userID.equals(cusAcc.get(i).getEmail())) {
                if (userPass.equals(cusAcc.get(i).getPassword()))
                    this.currAcc = cusAcc.get(i);
                    System.out.println("Successfully logged in");
                    return true;
            }
            
        }
        System.out.println("Invalid, try again");
        return false;
    }
    
    public boolean authenticateAdminAccount() {
        System.out.println("Enter Email: ");
        String userID = sc.next();
        System.out.println("Enter Password: ");
        String userPass = sc.next();
        
        if(userID.equals("DummyID")) {
            if(userPass.equals("Password123"))
                System.out.println("Successfully logged in");
                return true;
        }
        
        System.out.println("Invalid, try again");
        return false;
    }

    
    /*
     * allow appEntry to terminate app
     * 
     */
    public void setObject(AppEntry appEnt) {
        
        this.appEnt = appEnt; 
    }
    
}
