package controller;

import java.util.HashMap;
import java.util.List;

public class FilteringData {
    private FilterAlgorithm algorithm;
    private List<HashMap> raw_data;
    private List<String[]> tweet_row;
    private String filterContent;

    public FilteringData(FilterAlgorithm algorithm, List<HashMap> raw_data, List<String[]> tweet_row, String filterContent){
        this.algorithm = algorithm;
        this.raw_data = raw_data;
        this.tweet_row = tweet_row;
        this.filterContent = filterContent;
    }

    public FilterAlgorithm getAlgorithm(){
        return this.algorithm;
    }

    public List<HashMap> filterData(){
        return algorithm.filter(raw_data, tweet_row, filterContent);
    }
}
