package model;

import java.sql.*;
import java.util.*;


public class TweeterAbstract implements TweeterObject{
    @Override
    public void declare() {
        System.out.println("This is a tweeter abstract object.");
    }

    @Override
    public String getTweeter() {
        String result = "";
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT tweeter FROM " + "tweeterabstract");
            while (rs.next())
            {
                // System.out.println(rs.getString("tweeter"));
                result = result + rs.getString("tweeter") + " ";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Integer> getTotalCount() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT totalcount FROM " + "tweeterabstract");
            while (rs.next())
            {
                // System.out.println(rs.getString("totalcount"));
                result.add(rs.getInt("totalcount"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getDate() {
        String result = "";
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT earliest, latest FROM " + "tweeterabstract");
            /*List list = new ArrayList();
            ResultSetMetaData md = rs.getMetaData();//获取键名
            int columnCount = md.getColumnCount();//获取行的数量
            while (rs.next()) {
                Map rowData = new HashMap();//声明Map
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
                }
                list.add(rowData);
            }
            System.out.println(list);*/
            while (rs.next())
            {
                // System.out.println(rs.getString("earliest"));
                // System.out.println(rs.getString("latest"));
                result = result + rs.getString("earliest") + " " + rs.getString("latest") + " ";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
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
    public ArrayList getEveryTweet(String detailname){
        System.out.println("Forbidden Method Call!");
        return null;
    }
}
