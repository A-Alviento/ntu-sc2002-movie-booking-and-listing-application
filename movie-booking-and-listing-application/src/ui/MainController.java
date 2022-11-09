package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import io.*;

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
     * UI Controllers
     * 
     */
    protected AccManager accMan;
    protected MovieController movCont;
    
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
    public MainController(ModelDatabaseController mdc, AppEntry appEnt) {
        
        /*
         * Ensures this MainController has a reference back
         * to the current instance of AppEntry; allows appEntry 
         * to terminate app
         * 
         */
        this.appEnt = appEnt;
        
        /*
         * Ensures all UI components has a reference
         * back to this instance of MainController
         * 
         */
        cineplex = new CineplexUI(this);
        admin.setMainController(this);
        user = new UserMenuUI(this);
        movie = new MovieUI(this);
        
        
        accMan = new AccManager(this);
        movCont = new MovieController(this);
        
        cusAcc = new ArrayList<>();
        movList = new ArrayList<>();
        cinPlex = new ArrayList<>();
        
        /*
         * Initialises cineplexes and their opening time
         * 
         */
        for (int i = 0; i < 3; i++)
            cinPlex.add(new Cineplexes("Location " + i, 8));
        
        
        /*
         * TODO:
         * Extract from DB movies, customers, and cineplexes
         * 
         */
        
        
        /*
         * When app first started, we have no current movie,
         * account or cineplex chosen
         * 
         */
        currAcc = null;
        currMov = null;
        currCineplex = null;
    }
   
    
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
                    auth = accMan.authenticateUserAccount();
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
                accMan.makeAccount();
                
                // once account created, go back to login page
                return -1;
                // case for user sign up
                
            // case for guest user
            case 3:
                if (!cineplex.displayCineplexUI()) {
                    currAcc = null;
                    return -1;
                }
                if (!user.displayMainUI()) {
                    currAcc = null;
                    return -1;
                }
                
                return 1;
                
            //case for admin login
            case 4:
                // authenticates admin login
                while(!auth)
                    auth = accMan.authenticateAdminAccount();
                auth = false;
                
                // once authenticated, move on
                if (!admin.displayAdminUI()) 
                    return -1;
                
                return 1;
            
            // case to stop app
            case 5:
                appEnt.stop();
                return 1;
        }
        
        // else keep displaying the LoginUI
        return -1;
    }
    
    
}
