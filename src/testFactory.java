import model.*;
import java.util.List;


public class testFactory {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/emojiproject";
    private static String userName = "Vincent";
    private static String userPass = "Ljc19950925!";

    public static void main(String[] args) {
        TweeterFactory listFactory = new TweeterListFactory();
        TweeterObject listObject = listFactory.create();
        UserAuth auth = UserAuth.getInstance();
        auth.setUserName(userName);
        auth.setUserPass(userPass);
        auth.Connect(driver, url);
        listObject.declare();
        System.out.println(listObject.getTweeter());
        System.out.println(listObject.getIntro());
        System.out.println(listObject.getDetailName());

        TweeterFactory abstractFactory = new TweeterAbstractFactory();
        TweeterObject abstractObject = abstractFactory.create();
        abstractObject.declare();
        System.out.println(abstractObject.getTweeter());
        System.out.println(abstractObject.getTotalCount());
        System.out.println(abstractObject.getDate());

        TweeterFactory detailFactory = new TweeterDetailFactory();
        TweeterObject detailObject = detailFactory.create();
        detailObject.declare();
        List list = detailObject.getEveryTweet(listObject.getDetailName());
        System.out.println(list.get(0));
        System.out.println(list.get(200));
        System.out.println(list.get(500));
        System.out.println(list.get(abstractObject.getTotalCount().get(0)-1));
    }
}
