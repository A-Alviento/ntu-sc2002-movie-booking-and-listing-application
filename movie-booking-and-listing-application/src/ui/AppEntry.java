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
        login = new LoginUI();
        mC = new MainController();
        
        login.setMainController(mC);
        mC.setObject(this);
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
