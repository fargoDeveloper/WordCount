import java.util.*;

/**
 * This class, to count the number of duplicated words,
 * connects all the necessary classes and runs their methods for execution.
 */
public class WordCounterApp {
    public static final String FILE_NAME = "C://WorkTasks//WordCounter//bigNote.txt";

    public static void main(String[] args) {
        my.sample.app.FromFileReader fromFileReader = new my.sample.app.FromFileReader();
        LineConverter lineConverter = new LineConverter();
        my.sample.app.DuplicateCounter duplicateCounter = new my.sample.app.DuplicateCounter();
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME);

        for (String line : linesFromFile) {
            if (!line.isEmpty()) {
                List<String> words = lineConverter.extractWords(line);
                duplicateCounter.countWords(words, wordCountMap);
            }
        }


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
