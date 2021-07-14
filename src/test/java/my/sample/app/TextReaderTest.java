package my.sample.app;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextReaderTest {

    TextReader textReader;

    @Before
    public void initObjects() {
        textReader = new TextReader();
    }

    @Test
    public void loadFromFile() throws IOException {
        String fileName = ("src/main/resources/testFile.txt");
        List<String> linesFromFile = textReader.loadFromFile(fileName);
        assertEquals(5, linesFromFile.size());
    }

    @Test
    public void loadFromEmptyFile() throws IOException {
        String fileName = ("src/main/resources/testEmptyFile.txt");
        List<String> linesFromFile = textReader.loadFromFile(fileName);
        assertEquals(0, linesFromFile.size());
    }

    @Test (expected = FileNotFoundException.class)
    public void loadFromNonExistFile() throws IOException {
        String fileName = ("src/main/resources/someFile.txt");
        List<String> linesFromFile = textReader.loadFromFile(fileName);
    }

    @Test
    public void loadFromResources() throws IOException {
        String fileName = ("testFile.txt");
        List<String> linesFromResource = textReader.loadFromResource(fileName);
        assertEquals(5, linesFromResource.size());
    }
}
