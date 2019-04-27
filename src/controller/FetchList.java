package controller;
import java.util.*;
import model.*;

public class FetchList {
    private List<String> nameList;
    private List<String> introList;
    private List<String> detailList;

    public FetchList(){
        TweeterFactory listFactory = new TweeterListFactory();
        TweeterObject listObject = listFactory.create();
        setNameList(listObject.getTweeter());
        setIntroList(listObject.getIntro());
        setDetailList(listObject.getDetailName());
    }

    public List<String> getNameList() {
        return nameList;
    }

    private void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getIntroList() {
        return introList;
    }

    private void setIntroList(List<String> introList) {
        this.introList = introList;
    }

    public List<String> getDetailList() {
        return detailList;
    }

    private void setDetailList(List<String> detailList) {
        this.detailList = detailList;
    }



}
