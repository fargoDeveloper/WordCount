package my.sample.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DuplicationCounterTest {
    DuplicateCounter duplicateCounter;
    HashMap<String, Integer> wordCountMap;

    @Before
    public void initObjects() {
        duplicateCounter = new DuplicateCounter();
        wordCountMap = new HashMap<>();
    }

    @Test
    public void getDuplicateWords() {
        List<String> wordsList = new ArrayList<>();
        HashMap<String, Integer> wordCount;
        wordsList.add("жили");
        wordsList.add("жили");
        wordsList.add("себе");
        wordsList.add("дед");
        wordsList.add("да");
        wordsList.add("баба");
        wordsList.add("дед");
        wordsList.add("говорит");
        wordCount = duplicateCounter.countWords(wordsList, wordCountMap);
        assertEquals((Object) 2, wordCount.get("жили"));
        assertEquals((Object) 2, wordCount.get("дед"));
        assertEquals((Object) 1, wordCount.get("да"));
        assertEquals((Object) 1, wordCount.get("говорит"));
    }
}