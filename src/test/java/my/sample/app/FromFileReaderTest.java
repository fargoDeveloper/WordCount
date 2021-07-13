package my.sample.app;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FromFileReaderTest {
    FromFileReader fromFileReader = new FromFileReader();

    @Test
    public void loadFromFile() {
        final String FILE_NAME = "C://WorkTasks//WordCounter//TestFile.txt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME);
        assertEquals(7, linesFromFile.size());
    }
}
