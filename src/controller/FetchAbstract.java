package controller;
import java.util.*;
import model.*;


public class FetchAbstract {
    private List<String> nameList;
    private ArrayList<Integer> countList;
    private List<String> dateList;

    public FetchAbstract(){
        TweeterFactory abstractFactory = new TweeterAbstractFactory();
        TweeterObject abstractObject = abstractFactory.create();
        setNameList(abstractObject.getTweeter());
        setCountList(abstractObject.getTotalCount());
        setDateList(abstractObject.getDate());
    }

    public List<String> getNameList() {
        return nameList;
    }

    private void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public ArrayList<Integer> getCountList() {
        return countList;
    }

    private void setCountList(ArrayList<Integer> countList) {
        this.countList = countList;
    }

    public List<String> getDateList() {
        return dateList;
    }

    private void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

}
