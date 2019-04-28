package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiWordFilter extends SingleWordFilter implements AdvancedFilterAlgorithm{
    @Override
    public List<HashMap> filter(List<HashMap> raw_data, List<String[]> tweet_row, String filterContent){
        return advancedFilter(raw_data, tweet_row, filterContent.split(" "));
    }

    @Override
    public List<HashMap> advancedFilter(List<HashMap> raw_data, List<String[]> tweet_row, String[] filterContent) {
        List<HashMap> result =new ArrayList<>();
        for (HashMap row: raw_data){
            String index = row.get("text").toString();
            boolean match = true;
            for (String word: filterContent){
                match = match && index.contains(word);
            }
            if (match){
                result.add(row);
            }
        }
        return result;
    }
}
