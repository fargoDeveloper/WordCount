package my.sample.app;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LineConverterTest {
    LineConverter lineConverter = new LineConverter();

    @Test
    public void getConvertLine() {
        List<String> linesFromFile = Arrays.asList("Жили, ! себе -дед да; баба. Дед говорит бабе");
        List<String> wordsList = lineConverter.extractWords(linesFromFile.get(0));
        assertEquals(8, wordsList.size());
    }
}
