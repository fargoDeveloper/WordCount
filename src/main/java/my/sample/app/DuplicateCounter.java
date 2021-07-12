package my.sample.app;

import java.util.HashMap;
import java.util.List;

/**
 * This class count the number of duplicate word in the input file
 */
public class DuplicateCounter {
    public HashMap countWords(List<String> words, HashMap<String, Integer> wordCountMap1) {
        for (String word : words) {
            if (wordCountMap1.keySet().contains(word)) {
                wordCountMap1.put(word, wordCountMap1.get(word) + 1);
            } else {
                wordCountMap1.put(word, 1);
            }
        }
        return wordCountMap1;
    }
}
