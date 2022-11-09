package ui;

import io.ModelDatabaseController;

/*
 * Serves as CLI entry point
 * 
 */
public class AppEntry {
    
    private boolean stop;
    private LoginUI login;
    private MainController mC;
    private ModelDatabaseController mdc;
    
    public AppEntry(ModelDatabaseController mdc) {
        
        this.mdc = mdc;
        stop = false;
        mC = new MainController(mdc, this);
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
