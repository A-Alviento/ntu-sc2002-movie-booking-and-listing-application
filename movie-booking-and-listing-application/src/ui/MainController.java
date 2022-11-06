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
 
    /*
     * UI Components
     * 
     */
    protected AppEntry appEnt;
    protected CineplexUI cineplex;
    protected AdminMenuUI admin;
    protected UserMenuUI user;
    protected MovieUI movie;
    
    /*
     * Components related to entity  classes
     * 
     */
    protected ArrayList<CustomerAccount> cusAcc;
    protected ArrayList<Movie> movList;
    protected ArrayList<Cineplexes> cinPlex;
    
    /*
     * Stores the current account being used
     * and the current movie being viewed
     * 
     */
    protected CustomerAccount currAcc;
    protected Movie currMov;
    protected Cineplexes currCineplex;
    
      
    
    /*
     * Constructor; Initializes all default components
     * 
     */
    public MainController() {
        
        /*
         * Ensures all UI components has an association
         * back to this instance of MainController
         * 
         */
        cineplex.setMainController(this);
        admin.setMainController(this);
        user.setMainController(this);
        movie.setMainController(this);
        
        cusAcc = new ArrayList<>();
        movList = new ArrayList<>();
        cinPlex = new ArrayList<>();
        
        for (int i = 0; i < 3; i++)
            cinPlex.add(new Cineplexes("Location " + i, 8));
 
        currAcc = null;
        currMov = null;
        currCineplex = null;
    }
   
    
    
    /*
     * TODO:
     * IMPLEMENT OR INTEGRATE METHOD TO EXTRACT
     * LIST OF MOVIES FROM DB INTO AN ARRAYLIST
     * 
     */
    

    
    /*
     * Takes in user input for LoginUI and from there onwards
     * processes the options accordingly as specified 
     * 
     */
    public int login(int selection) {
        boolean auth = false;
        
        switch(selection){
            // case for user login
            case 1:
                // authenticates customer login
                while(!auth)
                    auth = this.authenticateUserAccount();
                auth = false;
                
                // once authenticated, move on 
                if (!cineplex.displayCineplexUI()) {
                    currAcc = null;
                    return -1;
                }
                if (!user.displayMainUI()) {
                    currAcc = null;
                    return -1;
                }
                
                return 1;
                
            // case for user sign up
            case 2:
                CustomerAccount c = new CustomerAccount();
                c.createAccount();
                cusAcc.add(c);
                System.out.println("Account created");
                
                // once account created, go back to login page
                return -1;
                
            //case for admin login
            case 3:
                // authenticates admin login
                while(!auth)
                    auth = this.authenticateAdminAccount();
                auth = false;
                
                // once authenticated, move on
                if (!admin.displayAdminUI()) 
                    return -1;
                
                return 1;
            
            // case to stop app
            case 4:
                appEnt.stop();
                return 1;
        }
        
        // else keep displaying the LoginUI
        return -1;
    }
    
    /*
     * authenticates customer account by checking with list 
     * of accounts stored in cusAcc arraylist
     * 
     */
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
    
    /*
     * authenticates admin account by checking with pre
     * determined list of authorised accounts
     * 
     */
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
     * allows appEntry to terminate app
     * 
     */
    public void setObject(AppEntry appEnt) {
        
        this.appEnt = appEnt; 
    }
    
}
