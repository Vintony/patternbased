package controller;

import java.util.*;
import java.util.regex.Pattern;

public class DataPreprocess {
    private List<HashMap> raw_data;
    private List<String[]> tweet_row;
    private int[] tweet_count;
    private List<Map.Entry<String, Integer>> word_frequency_order;


    public DataPreprocess(List<String> detailName){
        raw_data = new ArrayList<>();
        tweet_row = new ArrayList<>();
        for (String s : detailName) {
            FetchDetail fetchDetail = new FetchDetail(s);
            raw_data.addAll(fetchDetail.getRawTweet());
        }
        tweet_count = new int[raw_data.size()];
        format(raw_data);
        WordFrequency();
    }

    public void changeContent(List<HashMap> new_data){
        raw_data.clear();
        tweet_row.clear();
        word_frequency_order.clear();
        setRaw_data(new_data);
        ReCalculate();
    }

    private void ReCalculate(){
        tweet_count = new int[raw_data.size()];
        format(raw_data);
        WordFrequency();
    }

    private void format(List<HashMap> raw_data){
        for (int i = 0; i < raw_data.size(); i++){
            String text = raw_data.get(i).get("text").toString();
            String[] words = text.split(" ");

            String pattern1 = "httpstco.*";

            for (int k = 0; k < words.length; k++){
                words[k] = words[k].replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                if (Pattern.matches(pattern1, words[k])){
                    words[k] = "SHORT LINK";
                }
            }
            tweet_row.add(words);
            tweet_count[i] = words.length;
        }
    }

    private void WordFrequency(){
        HashMap<String, Integer> word_frequency = new HashMap<>();
        String pattern1 = "rt|SHORT LINK|a|an|the|am|is|are|i|he|she|it|my|mine|his|her|its|this|that|they|have|has|all|only";
        String pattern2 = "in|at|on|these|those|and|for|to|you|your|do|did|of|with|our|we|be|:|was|were|amp|by|not|as|their";
        String pattern3 = "who|so|will|or|there|can|could|what|us|from|been|pm|about|if|me|which|them|should|when|must|into|done|";
        for (String[] words : tweet_row) {
            for (String index : words) {
                if (!(Pattern.matches(pattern1, index) || Pattern.matches(pattern2, index)||Pattern.matches(pattern3, index))) {
                    word_frequency.merge(index, 1, Integer::sum);
                }
            }
        }
        word_frequency.entrySet().removeIf(entry -> entry.getValue()<5);
        word_frequency_order = new ArrayList<>(word_frequency.entrySet());
        word_frequency_order.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        /*for (Map.Entry<String, Integer> stringIntegerEntry : word_frequency_order) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }*/
    }

    public List<HashMap> getRaw_data() {
        return raw_data;
    }

    private void setRaw_data(List<HashMap> raw_data) {
        this.raw_data = raw_data;
    }

    public int[] getTweet_count() {
        return tweet_count;
    }

    public List<Map.Entry<String, Integer>> getWord_frequency_order() {
        return word_frequency_order;
    }
}
