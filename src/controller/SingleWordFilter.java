package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SingleWordFilter implements BasicFilterAlgorithm {
    @Override
    public List<HashMap> filter(List<HashMap> raw_data, List<String[]> tweet_row, String filterContent) {
        List<HashMap> result = new ArrayList<>();
        for (HashMap row : raw_data) {
            if (row.get("text").toString().contains(filterContent)) {
                result.add(row);
            }
        }
        return result;
    }
}
