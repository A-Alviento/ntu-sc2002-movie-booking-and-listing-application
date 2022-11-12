package ui;

import java.util.Scanner;

import model.CustomerAccount;

/**
 * Serves as the UI element for users or
 * admin to login.
 * 
 */
public class AccManagerUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public AccManagerUI(MainController mC) {
        
        this.mC = mC;
    }
    
    /**
     * Authenticates customer account by checking with list 
     * of accounts stored in cusAcc arraylist
     * 
     */
    public boolean authenticateUserAccount() {
        
        String userID = CheckUserInput.loopUntilValidString("Enter Email: \n", 0);
        
        String userPass = CheckUserInput.loopUntilValidString("Enter Password: \n", 0);
        
        int len = mC.cusAcc.size();
         
        for (int i = 0; i < len; i++) {
            if (userID.toLowerCase().equals(mC.cusAcc.get(i).getEmail().toLowerCase())) {
                if (userPass.equals(mC.cusAcc.get(i).getPassword())) {
                    mC.currAcc = mC.cusAcc.get(i);
                    System.out.println("Successfully logged in");
                    
                    return true;
                }
            }
            
        }
        System.out.println("Invalid, try again");
        return false;
    }
    
    /**
     * Authenticates admin account by checking with pre
     * determined list of authorised accounts
     * 
     */
    public boolean authenticateAdminAccount() {
        
        String userID = CheckUserInput.loopUntilValidString("Enter Email: \n", 0);

        String userPass = CheckUserInput.loopUntilValidString("Enter Password: \n", 0);
        
        if(userID.equals("DummyID")) {
            if(userPass.equals("123")) {
                System.out.println("Successfully logged in");
                return true;
            }
        }
        
        System.out.println("Invalid, try again");
        return false;
    

    }
    
    /**
     * Create user account
     * 
     */
    public void makeAccount() {
        
        CustomerAccount c = new CustomerAccount();
        c.createAccount();
        mC.cusAcc.add(c);
        
        System.out.println("Account created");

    }
}
