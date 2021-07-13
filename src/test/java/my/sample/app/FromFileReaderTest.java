package my.sample.app;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FromFileReaderTest {
    FromFileReader fromFileReader;

    @Before
    public void initObjects() {
        fromFileReader = new FromFileReader();
    }

    @Test
    public void loadFromFile() throws URISyntaxException {
        URL url = getClass().getClassLoader().getResource("testFile.txt");
        File file = Paths.get(url.toURI()).toFile();
        String fileName = file.getAbsolutePath();

        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);
        assertEquals(7, linesFromFile.size());
    }

    @Test
    public void loadFromEmptyFile() throws URISyntaxException {
        URL url = getClass().getClassLoader().getResource("testEmptyFile.txt");
        File file = Paths.get(url.toURI()).toFile();
        String fileName = file.getAbsolutePath();

        List<String> linesFromFile = fromFileReader.loadFromFile(fileName);
        assertEquals(0, linesFromFile.size());
    }
}
