package my.sample.app;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LineConverterTest {

    LineConverter lineConverter;

    @Before
    public void initObjects() {
        lineConverter = new LineConverter();
    }

    @Test
    public void getConvertLine() throws IOException {
        String testString = "Жили, ! себе -дед да; баба. Дед говорит бабе";
        Reader reader = new StringReader(testString);
        BufferedReader buffer = new BufferedReader(reader);

        List<String> wordsList = lineConverter.extractWords(buffer.readLine());
        assertEquals(8, wordsList.size());
    }
}
