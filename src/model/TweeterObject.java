package model;

import java.util.*;

public interface TweeterObject {
    public void declare();

    public String getTweeter();

    public String getIntro();

    public String getDetailName();

    public ArrayList<Integer> getTotalCount();

    public String getDate();

    public List getEveryTweet(String detailname);
}
