package model;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TweeterList implements TweeterObject {
    @Override
    public void declare() {
        System.out.println("This is an tweeter list object");
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT * FROM " + "tweeterlist");
            while (rs.next())
            {
                System.out.println(rs.getString("tweeter") + " " + rs.getString("intro"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List getTweeter(){
        List<String> result = new ArrayList<>();
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT tweeter FROM " + "tweeterlist");
            while (rs.next())
            {
                // System.out.println(rs.getString("tweeter"));
                result.add(rs.getString("tweeter"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public List getIntro() {
        List<String> result = new ArrayList<>();
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT intro FROM " + "tweeterlist");
            while (rs.next())
            {
                // System.out.println(rs.getString("intro"));
                result.add(rs.getString("intro"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List getDetailName() {
        List<String> result = new ArrayList<>();
        try {
            UserAuth auth = UserAuth.getInstance();
            ResultSet rs = auth.executeQuery("SELECT detailname FROM " + "tweeterlist");
            while (rs.next())
            {
                // System.out.println(rs.getString("detailname"));
                result.add(rs.getString("detailname"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Integer> getTotalCount() {
        System.out.println("Forbidden Method Call!");
        return null;
    }

    @Override
    public List getDate() {
        System.out.println("Forbidden Method Call!");
        return null;
    }

    @Override
    public ArrayList getEveryTweet(String detailname){
        System.out.println("Forbidden Method Call!");
        return null;
    }

}
