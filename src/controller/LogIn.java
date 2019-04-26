package controller;
import java.sql.*;
import model.UserAuth;


public class LogIn {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/emojiproject";
    public LogIn(String userName, String userPass) {
        UserAuth auth = UserAuth.getInstance();
        auth.setUserName(userName);
        auth.setUserPass(userPass);
    }

    public boolean Connect() {
        try {
            UserAuth auth = UserAuth.getInstance();
            auth.Connect(driver, url);
            if (auth.executeQuery("SELECT * FROM tweeterlist") != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
