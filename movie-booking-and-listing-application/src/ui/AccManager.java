package ui;

import java.util.Scanner;

public class AccManager {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public AccManager(MainController mC) {
        
        this.mC = mC;
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
        
        int len = mC.cusAcc.size();
        
        for (int i = 0; i < len; i++) {
            if (userID.equals(mC.cusAcc.get(i).getEmail())) {
                if (userPass.equals(mC.cusAcc.get(i).getPassword()))
                    mC.currAcc = mC.cusAcc.get(i);
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
}
