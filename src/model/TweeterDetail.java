package model;
import java.sql.*;
import java.util.*;


public class TweeterDetail implements TweeterObject {
    @Override
    public void declare() {
        System.out.println("This is a tweeter detail object.");
    }

    @Override
    public List getEveryTweet(String detailname){
        List list = new ArrayList();
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT * FROM " + detailname);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {

                Map rowData = new HashMap();

                for (int i = 1; i <= columnCount; i++) {

                    rowData.put(md.getColumnName(i), rs.getObject(i));

                }
                list.add(rowData);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getTweeter() {
        System.out.println("Forbidden Method Call!");
        return null;
    }

    @Override
    public String getIntro() {
        System.out.println("Forbidden Method Call!");
        return null;
    }

    @Override
    public String getDetailName() {
        System.out.println("Forbidden Method Call!");
        return null;
    }

    @Override
    public ArrayList<Integer> getTotalCount() {
        System.out.println("Forbidden Method Call!");
        return null;
    }

    @Override
    public String getDate() {
        System.out.println("Forbidden Method Call!");
        return null;
    }
}
