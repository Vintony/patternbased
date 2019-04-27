package controller;
import java.util.*;
import model.*;

public class FetchDetail {
    private List rawTweet;

    public FetchDetail(String detailName){
        TweeterFactory detailFactory = new TweeterDetailFactory();
        TweeterObject detailObject = detailFactory.create();
        setRawTweet(detailObject.getEveryTweet(detailName));
    }

    public List getRawTweet() {
        return rawTweet;
    }

    private void setRawTweet(List rawTweet) {
        this.rawTweet = rawTweet;
    }
}
