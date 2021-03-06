package controller;

import java.util.HashMap;
import java.util.List;

public class MultiWordState implements FilterState{
    private static final AdvancedFilterAlgorithm multiWordFilter = new MultiWordFilter();
    private List<HashMap> raw_data;
    private List<String[]> tweet_row;
    private String filterContent;

    @Override
    public String[] ApplyFilter(String FilterContent, DataDisplay dataDisplay) {
        this.raw_data = dataDisplay.getRaw_data();
        this.tweet_row = dataDisplay.getTweet_row();
        this.filterContent = FilterContent;
        FilteringData filteringData = new FilteringData(multiWordFilter, this.raw_data, this.tweet_row, this.filterContent);
        List<HashMap> new_raw_data = filteringData.filterData();
        dataDisplay.changeContent(new_raw_data);
        return dataDisplay.FetchDisplayData();
    }
}
