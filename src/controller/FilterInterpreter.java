package controller;

public class FilterInterpreter {
    private String filterContent;
    private DataDisplay dataDisplay;

    private static final FilterState singleWordState = new SingleWordState();

    private FilterState state = singleWordState;


    public FilterInterpreter(String filterContent, DataDisplay dataDisplay){
        this.filterContent = filterContent;
        this.dataDisplay = dataDisplay;
    }

    private void interpreter(){
        if (true){
            this.state = singleWordState;
        }
    }

    public String[] DisplayNewData(){
        return state.ApplyFileter(filterContent,dataDisplay);
    }
}
