package my.sample.app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LineConverter {
    /**
     * Extract only words
     */
    public List<String> extractWords(String linesFromFile) {

        String line = linesFromFile;
        List<String> wordsList = new LinkedList<>();
        List<String> convertedList;

        // Remove spaces at the beginning and end of the line
        line = line.trim();

        // Convert all characters to lowercase
        line = line.toLowerCase();

        // remove extra characters in to line
        line = line.replaceAll("[//\\()?–—:_!@~`#№$%^&*=\'\"\t\b\r.\\+,;\n{}<>]+", "");
        line = line.replaceAll("[\\xC2\\xA0]+", " ");

        // Creating an list of strings
        convertedList = Arrays.asList(line.split(" "));

        for (int i = 0; i < convertedList.size(); i++) {
            if (!convertedList.get(i).equals("")) {
                wordsList.add(convertedList.get(i));
            }
        }
        return wordsList;
    }
}
