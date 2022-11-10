package ui;

import io.ModelDatabaseController;

/*
 * Serves as CLI entry point
 * 
 */
public class AppEntry {
    
    private boolean stop;
    private AppEntryUI login;
    private MainController mC;
    
    public AppEntry(ModelDatabaseController mdc) throws Exception {
        
        stop = false;
        mC = new MainController(mdc, this);
        login = new AppEntryUI(mC);
        
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
