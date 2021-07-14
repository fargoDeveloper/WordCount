package my.sample.app;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<String> wordsList;
        HashMap<String, Integer> wordCount;

        Stream<String> stringStream = Stream.of("жили", "жили", "себе", "дед", "да", "баба", "дед", "говорит");
        wordsList = stringStream.collect(Collectors.toList());

        wordCount = duplicateCounter.countWords(wordsList, wordCountMap);
        assertEquals((Object) 2, wordCount.get("жили"));
        assertEquals((Object) 2, wordCount.get("дед"));
        assertEquals((Object) 1, wordCount.get("да"));
        assertEquals((Object) 1, wordCount.get("говорит"));
    }
}