import java.sql.ResultSet;
import java.sql.SQLException;

public class testApp {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String userName = "Vincent";
    private static String userPass = "Ljc19950925!";
    private static String tableName = "test_table";
    private static String columnLabel = "test_column";

    public static void main(String[] args) {
        try {
            JDBCconnecter connecter = new JDBCconnecter();
            connecter.Connect(driver, url, userName, userPass);
            ResultSet rs = connecter.executeQuery("SELECT * FROM " + tableName);
            while (rs.next())
            {
                System.out.println(rs.getString(columnLabel));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
