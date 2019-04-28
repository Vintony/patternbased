package controller;

import java.util.ArrayList;
import java.util.List;

public class FrequencyResult extends AnalysisResult {
    private DataDisplay dataDisplay;
    private List<AnalysisResult> results;

    public FrequencyResult(){
        results = new ArrayList<>();
    }

    public FrequencyResult(DataDisplay dataDisplay){
        this.dataDisplay = dataDisplay;
        super.setValue(dataDisplay.getWord_frequency_order());
        results = new ArrayList<>();
    }

    @Override
    protected void add(AnalysisResult result) {
        results.add(result);
    }

    @Override
    protected void romove(AnalysisResult result) {
        results.remove(result);
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getValue());
        for (AnalysisResult c : results) {
            c.display(depth + 2);
        }
    }
}
