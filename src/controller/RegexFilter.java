package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class RegexFilter implements AdvancedFilterAlgorithm{
    @Override
    public List<HashMap> filter(List<HashMap> raw_data, List<String[]> tweet_row, String filterContent) {
        String[] regexContent = new String[1];
        regexContent[0] = filterContent;
        return advancedFilter(raw_data, tweet_row, regexContent);
    }

    @Override
    public List<HashMap> advancedFilter(List<HashMap> raw_data, List<String[]> tweet_row, String[] filterContent) {
        List<HashMap> result =new ArrayList<>();
        for (HashMap row: raw_data){
            if (Pattern.matches(filterContent[0], row.get("text").toString())){
                result.add(row);
            }
        }
        return result;
    }
}
