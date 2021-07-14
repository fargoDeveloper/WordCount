package my.sample.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads data from the input file
 */
public class FromFileReader {
    String line;
    List<String> wordsList = new ArrayList<>();

    public List<String> loadFromFile(String fileName) throws FileNotFoundException {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((line = reader.readLine()) != null) {
                wordsList.add(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return wordsList;
    }
}
