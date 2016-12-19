package init;

import core.Agent;
import gui.MainGui;
import gui.MainLogin;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class WindowManager {

    protected static int authLogged;
    protected static Agent tmpAgent = null;
    protected static JLabel welcome = null;

    //Window Management
    protected static JPanel currentWindow = null;
    protected static JPanel lastWindow = null;
    protected static JFrame mainFrame;
    protected static JFrame loginFrame;

    //======================================= Main ==========================================
    public static void openLogin() throws SQLException {
         loginFrame= new MainLogin();
    }
    public static void startMain(){
        
        mainFrame = new MainGui();
        welcome = new JLabel();
        welcome.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        mainFrame.getContentPane().add(welcome, mainFrame.getContentPane().countComponents()-1);
        welcome.setBounds(440, 30, 500, 50);
        welcome.setText("Welcome "+getTmpAgent().getFirstName()+" "+getTmpAgent().getLastName());
    }
    public static void closeMain() throws SQLException {
        mainFrame.dispose();
        loginFrame = new MainLogin();
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
        getCurrentWindow().setBounds(280, 90, 810, 595);
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
                toReturn = "EMPLOYEE";
                break;
            default:
                toReturn = "ERROR";
                break;
        }
        return toReturn;

    }

    public static Color getAuthColor() {
        Color color = Color.white;
        switch (authLogged) {
            case 1:
                color = Color.green;
                break;
            case 2:
                color = Color.orange;
                break;
            case 3:
                color = Color.blue;
                break;
            case 4:
                color = Color.red;
                break;

        }
        return color;
    }

    public static int getAuthValue() {
        return authLogged;
    }

    public static void setUser(int AuthType, Object user) {
        if (AuthType <= 0) {
            return;
        }
        if (user == null) {
            return;
        }
        authLogged = AuthType;
        switch (AuthType) {
            case 1:
                
                tmpAgent = (Agent)user;

                break;
            default:
                System.err.println("EMPLOYEE");
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

    public static void clean() {
        authLogged = 0;
        currentWindow = null;
        welcome = null;
        tmpAgent = null;
    }

    public static void update() {
        if (getCurrentWindow() == null) {
            return;
        }
        getCurrentWindow().setVisible(false);
        getCurrentWindow().setVisible(true);
    }

    public static void update(JInternalFrame frame) {
        frame.setVisible(false);
        frame.setVisible(true);
    }
}
