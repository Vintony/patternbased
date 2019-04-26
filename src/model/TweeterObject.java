package model;

import java.util.*;

public interface TweeterObject {
    public void declare();

    public List getTweeter();

    public List getIntro();

    public List getDetailName();

    public ArrayList<Integer> getTotalCount();

    public List getDate();

    public List getEveryTweet(String detailname);
}
