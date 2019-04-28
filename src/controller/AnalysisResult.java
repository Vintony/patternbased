package controller;

import java.util.List;
import java.util.Map;

public abstract class AnalysisResult {
    private List<Map.Entry<String, Integer>> value;
    private DataDisplay dataDisplay;

    public AnalysisResult(List<Map.Entry<String, Integer>> value, DataDisplay dataDisplay) {
        this.value = value;
        this.dataDisplay = dataDisplay;
    }

    public AnalysisResult() {
    }

    public List<Map.Entry<String, Integer>> getValue() {
        return value;
    }

    public void setValue(List<Map.Entry<String, Integer>> value) {
        this.value = value;
    }

    protected abstract void add(AnalysisResult result);

    protected abstract void romove(AnalysisResult result);

    protected abstract void display(int depth);
}
