package my.sample.app;

import java.util.HashMap;
import java.util.List;

public class DuplicateCounter {
    /**
     * Count the number of duplicate word in a text
     */
    public HashMap countWords(List<String> words, HashMap<String, Integer> wordCountMap) {

        for (String word : words) {
            if (wordCountMap.keySet().contains(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        return wordCountMap;
    }
}
