package my.sample.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTester {
    FromFileReader fromFileReader = new FromFileReader();
    LineConverter lineConverter = new LineConverter();
    DuplicateCounter duplicateCounter = new DuplicateCounter();
    HashMap<String, Integer> wordCountMap = new HashMap<>();

    @Test
    public void loadFromFile() {
        final String FILE_NAME = "C://WorkTasks//WordCounter//TestFile.txt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME);
        assertEquals(6, linesFromFile.size());
    }

    @Test
    public void getConvertLine() {
        List<String> linesFromFile = Arrays.asList("Жили, ! себе -дед да; баба. Дед говорит бабе");
        List<String> wordsList = lineConverter.extractWords(linesFromFile.get(0));
        assertEquals(8, wordsList.size());
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
