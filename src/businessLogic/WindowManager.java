package businessLogic;

import entity.Agent;
import entity.User;
import boundary.MainGui;
import boundary.MainLogin;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class WindowManager {
    //Global parameters
    protected static int authLogged;
    protected static Agent tmpAgent = null;
    protected static User tmpUser = null;
    protected static JLabel welcome = null;

    //Window Management
    protected static JPanel currentWindow = null;
    protected static JPanel lastWindow = null;
    protected static JFrame mainFrame;
    protected static MainLogin loginFrame;

    //======================================= Main ==========================================
    public static void openLogin() throws SQLException {
        loginFrame = new MainLogin();
    }
    public static void startMain(){
        mainFrame = new MainGui();
        HandsInTheAir.getDM().setVisible(false);
        setWelcome();
    }
    public static void closeMain() {
        mainFrame.dispose();
        loginFrame = new MainLogin();
        clean();
        HandsInTheAir.getDM().setVisible(false);
    }
    public static void setCurrentWindow(JPanel panel) {
        currentWindow = panel;
    }
    public static JPanel getCurrentWindow() {
        return currentWindow;
    }
    public static void openWin(JPanel panel) {
        if (panel == null) {
            return;
        }

        if (getCurrentWindow() == null) {
            setCurrentWindow(panel);
        } else {
            if (panel == getCurrentWindow()) {
                panel.setVisible(true);
                return;
            } else {
                getCurrentWindow().setVisible(false);
                setLastWindow(getCurrentWindow());
                setCurrentWindow(panel);
            }
        }
        getCurrentWindow().setBounds(190, 90, 850, 580);
        mainFrame.getContentPane().add(getCurrentWindow(), mainFrame.getContentPane().countComponents()-1);
        mainFrame.getContentPane().setVisible(true);
        panel.setVisible(true);

        WindowManager.update();
        return;
    }
    public static void returnWindow() {
        if (getCurrentWindow() == null || getLastWindow() == null) {
            return;
        }
        getCurrentWindow().hide();
        JPanel tmp = getCurrentWindow();
        setCurrentWindow(getLastWindow());
        setLastWindow(tmp);

        WindowManager.update();
    }
    public static void setLastWindow(JPanel panel) {
        lastWindow = panel;
    }
    public static JPanel getLastWindow() {
        return lastWindow;
    }
    
    public static String getAuthType() {
        String toReturn = null;
        switch (authLogged) {
            case 1:
                toReturn = "Agent";
                break;
            case 2:
                toReturn = "Muza Representative";
                break;
            case 3:
                toReturn = "User";
                break;
            case 4:
                toReturn = "Place Representative";
                break;
            default:
                toReturn = "ERROR";
                break;
        }
        return toReturn;
    }
    public static JFrame getMainFrame() {
        return mainFrame;
    }
    public static int getAuthValue() {
        return authLogged;
    }
    public static void setUser(int AuthType, Object user) {
        if (AuthType <= 0) {
            return;
        }
        authLogged = AuthType;
        switch (AuthType) {
            case 1:
                tmpAgent = (Agent)user;
                break;
            case 2:
                tmpAgent = null;
                tmpUser = null;
                break;
            case 3:
                tmpUser = (User)user;
                break;
            case 4:
                tmpAgent = null;
                tmpUser = null;
                break;
            default:
                System.err.println("ERROR");
                break;
        }
        return;
    }
    public static void setTmpAgent(Agent agent) {
        tmpAgent = agent;
    }
    public static Agent getTmpAgent() {
        return tmpAgent;
    }
    public static User getTmpUser() {
        return tmpUser;
    }
    public static void setTmpUser(User tmpUser) {
        WindowManager.tmpUser = tmpUser;
    }

    public static MainLogin getLoginFrame() {
        return loginFrame;
    }
    
    public static void clean() {
        authLogged = 0;
        currentWindow = null;
        welcome = null;
        tmpAgent = null;
        tmpUser = null;
    }
    public static void update() {
        if (getCurrentWindow() == null) {
            return;
        }
        getCurrentWindow().setVisible(false);
        getCurrentWindow().setVisible(true);
    }
    public static void update(JFrame frame) {
        frame.setVisible(false);
        frame.setVisible(true);
    }
    private static void setWelcome() {
        welcome = new JLabel();
        welcome.setFont(new java.awt.Font("Dialog", 0, 36));
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        mainFrame.getContentPane().add(welcome, mainFrame.getContentPane().countComponents()-1);
        welcome.setBounds(400, 30, 500, 50);
        if (getTmpAgent()!= null)
            welcome.setText("Welcome "+getTmpAgent().getFirstName()+" "+getTmpAgent().getLastName());
        if (getTmpUser()!= null)
            welcome.setText("Welcome "+getTmpUser().getFirstName()+" "+getTmpUser().getLastName());
        else if (getTmpAgent() == null || getTmpUser() == null)
            welcome.setText("Welcome "+getAuthType());
    }
}
