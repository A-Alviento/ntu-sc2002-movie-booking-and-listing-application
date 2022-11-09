package ui;

/*
 * Serves as CLI entry point
 * 
 */
public class AppEntry {
    
    private boolean stop;
    private LoginUI login;
    private MainController mC;
    
    public AppEntry() {
        
        stop = false;
        mC = new MainController(o, this);
        login = new LoginUI(mC);
        
    }
    
    /*
     * start the application
     * 
     */
    public void start() {
        while (!stop) {
            login.displayLoginUI();
        }
    }
    
    /*
     * stop the application
     * 
     */
    public void stop() {
        stop = true;
    }

}
