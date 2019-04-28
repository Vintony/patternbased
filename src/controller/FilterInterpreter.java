package controller;

import java.util.Observable;

public class FilterInterpreter extends Observable {
    private String filterContent;
    private DataDisplay dataDisplay;

    private static final FilterState singleWordState = new SingleWordState();
    private static final FilterState multiWordState = new MultiWordState();
    private static final FilterState regexState = new RegexState();

    private FilterState state = singleWordState;


    public FilterInterpreter(String filterContent, DataDisplay dataDisplay){
        this.filterContent = filterContent;
        this.dataDisplay = dataDisplay;
        interpreter();
    }

    private void interpreter(){
        if (filterContent.startsWith("REGEX:")){
            this.filterContent = filterContent.replaceAll("REGEX:","");
            setChanged();
            this.notifyObservers(filterContent);
            this.state = regexState;
        } else if (filterContent.split(" ").length > 1){
            this.state = multiWordState;
        }else{
            this.state = singleWordState;
        }
    }

    public String[] DisplayNewData(){
        return state.ApplyFilter(filterContent,dataDisplay);
    }
}
