package my.sample.app;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class, to count the number of duplicated words,
 * connects all the necessary classes and runs their methods for execution.
 */
public class WordCounterApp {
    public static void main(String[] args) throws URISyntaxException {
        URL url = WordCounterApp.class.getClassLoader().getResource("file.txt");
        File file = Paths.get(url.toURI()).toFile();
        String fileName = file.getAbsolutePath();

        System.out.println("Starting application.");

        WordCounterApp app = new WordCounterApp();
        app.printDuplicates(app.wordCountApp(fileName));
    }

    public HashMap<String, Integer> wordCountApp(String fileName) {

        FromFileReader fromFileReader = new FromFileReader();
        LineConverter lineConverter = new LineConverter();
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        List<String> words;
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);

        for (String line : linesFromFile) {
            if (!line.isEmpty()) {
                words = lineConverter.extractWords(line);
                duplicateCounter.countWords(words, wordCountMap);
                words.clear();
            }
        }
        return wordCountMap;
    }

    public void printDuplicates(HashMap<String, Integer> wordCountMap) {
        System.out.println();
        System.out.println("List of duplicates and their number: " + wordCountMap);
        System.out.println();
        System.out.println("There are " + wordCountMap.size() + " words in the text.");

        System.out.println();
        System.out.println("------------------------ Sorted option ------------------------");

        Set<Map.Entry<String, Integer>> setWords = wordCountMap.entrySet();
        List<Map.Entry<String, Integer>> listWords = new ArrayList<>(setWords);
        listWords.sort(Map.Entry.comparingByValue());

        System.out.println();
        System.out.println("List of duplicates and their number: " + listWords);
        System.out.println();
        System.out.println("There are  " + listWords.size() + " words in the text.");
    }
}
