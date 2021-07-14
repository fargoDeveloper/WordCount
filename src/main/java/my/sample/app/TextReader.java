package my.sample.app;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads data from the input file
 */
public class TextReader {

    public List<String> loadFromFile(String fileName) throws IOException {
        List<String> wordsList = new ArrayList<>();
        String line;
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while ((line = reader.readLine()) != null) {
                wordsList.add(line);
            }
        }
        return wordsList;
    }

    public List<String> loadFromResource(String resourceName) throws IOException {

        InputStream stream = getClass().getClassLoader().getResourceAsStream(resourceName);
        InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        List<String> wordsList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            wordsList.add(line);
        }
        return wordsList;
    }
}
