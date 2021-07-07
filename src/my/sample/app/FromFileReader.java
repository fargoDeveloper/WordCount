package my.sample.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FromFileReader {
    /**
     * Read information from a file
     */
    public List<String> loadFromFile(String fileName) {
        String line;
        List<String> wordsList = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((line = reader.readLine()) != null) {
                wordsList.add(line);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return wordsList;
    }
}
