package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataDisplay {
    private DataPreprocess dataPreprocess;

    public DataDisplay(DataPreprocess dataPreprocess){
        this.dataPreprocess = dataPreprocess;
    }

    public void changeContent(List<HashMap> new_data){
        this.dataPreprocess.changeContent(new_data);
    }

    public List<HashMap> getRaw_data() {
        return this.dataPreprocess.getRaw_data();
    }

    public List<String[]> getTweet_row() {
        return this.dataPreprocess.getTweet_row();
    }

    public int[] getTweet_count() {
        return this.dataPreprocess.getTweet_count();
    }

    public List<Map.Entry<String, Integer>> getWord_frequency_order() {
        return this.dataPreprocess.getWord_frequency_order();
    }

    public String[] FetchDisplayData(){
        List<HashMap> raw_data = getRaw_data();
        String[] result = new String[raw_data.size()];
        for(int i = 0; i < raw_data.size(); i++){
            HashMap row = raw_data.get(i);
            result[i] = row.get("created_at").toString() + "  " + row.get("text").toString();
        }
        return result;
    }
}
