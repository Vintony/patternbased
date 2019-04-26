import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserAuth;
import controller.LogIn;

public class testApp {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/emojiproject";
    private static String userName = "Vincent";
    private static String userPass = "Ljc19950925!";
    private static String tableName = "twitter";
    private static String columnLabel1 = "id";
    private static String columnLabel2 = "tweet_id";

    public static void main(String[] args) {
        LogIn logIn = new LogIn("Vincent", "111111");
        if (logIn.Connect()){
            System.out.println("1");
        }else {
            System.out.println("0");
        }

        try {
            JDBCconnecter connecter = new JDBCconnecter();
            connecter.Connect(driver, url, userName, userPass);
            ResultSet rs = connecter.executeQuery("SELECT * FROM " + tableName);
            while (rs.next())
            {
                System.out.println(rs.getString(columnLabel1));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        try{
            UserAuth auth = UserAuth.getInstance();
            auth.setUserName(userName);
            auth.setUserPass(userPass);
            auth.Connect(driver, url);
            ResultSet rs = auth.executeQuery("SELECT * FROM " + tableName);
            while (rs.next())
            {
                System.out.println(rs.getString(columnLabel2));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
