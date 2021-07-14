package my.sample.app;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FromFileReaderTest {

    FromFileReader fromFileReader;

    @Before
    public void initObjects() {
        fromFileReader = new FromFileReader();
    }

    @Test
    public void loadFromFile() throws FileNotFoundException {
        String fileName = ("src/main/resources/testFile.txt");
        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);
        assertEquals(5, linesFromFile.size());
    }

    @Test
    public void loadFromEmptyFile() throws FileNotFoundException {
        String fileName = ("src/main/resources/testEmptyFile.txt");
        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);
        assertEquals(0, linesFromFile.size());
    }

    @Test
    public void loadFromNonExistFile() throws FileNotFoundException {
        String fileName = ("src/main/resources/someFile.txt");
        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);
        assertEquals(0, linesFromFile.size());

    }
}
