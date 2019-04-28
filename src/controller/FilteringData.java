package controller;

import java.util.HashMap;
import java.util.List;

public class FilteringData {
    private BasicFilterAlgorithm basicFilterAlgorithm = null;
    private AdvancedFilterAlgorithm advancedFilterAlgorithm = null;
    private List<HashMap> raw_data;
    private List<String[]> tweet_row;
    private String filterContent;

    public FilteringData(BasicFilterAlgorithm algorithm, List<HashMap> raw_data, List<String[]> tweet_row, String filterContent){
        this.basicFilterAlgorithm = algorithm;
        this.raw_data = raw_data;
        this.tweet_row = tweet_row;
        this.filterContent = filterContent;
    }

    public FilteringData(AdvancedFilterAlgorithm algorithm, List<HashMap> raw_data, List<String[]> tweet_row, String filterContent){
        this.advancedFilterAlgorithm = algorithm;
        this.raw_data = raw_data;
        this.tweet_row = tweet_row;
        this.filterContent = filterContent;
    }

    public List<HashMap> filterData(){
        if (basicFilterAlgorithm != null){
            return basicFilterAlgorithm.filter(raw_data, tweet_row, filterContent);
        }else {
            return advancedFilterAlgorithm.filter(raw_data, tweet_row, filterContent);
        }
    }
}
