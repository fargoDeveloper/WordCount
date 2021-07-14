package my.sample.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MockSampleTest {

    @Mock
    private FromFileReader fromFileReader;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void loadFromFile() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        when(fromFileReader.loadFromFile(any())).thenReturn(list);
        final String FILE_NAME = "fdhfdhfshdhxt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME);
        assertEquals(2, linesFromFile.size());
    }
}
