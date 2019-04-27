package controller;

import java.util.HashMap;
import java.util.List;

public interface FilterAlgorithm {
    public List<HashMap> filter(List<HashMap> raw_data, List<String[]> tweet_row, String filterContent);
}
