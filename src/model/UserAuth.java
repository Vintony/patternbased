package model;
import java.sql.*;

// singleton INSTANCE
public class UserAuth {
    private String userName;
    private String userPass;
    private Connection conn = null;
    private Statement statement = null;

    private UserAuth(){
        setUserName("");
        setUserPass("");
    }

    private static class UserAuthHolder{
        private final static UserAuth INSTANCE = new UserAuth();
    }

    public static UserAuth getInstance(){
        return UserAuthHolder.INSTANCE;
    }
    
    public void Connect(String driver,String jdbcUrl) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(jdbcUrl, userName, userPass);
            statement = conn.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try {
            return statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void Disconnect() {
        try {
            conn.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


}
