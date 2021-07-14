package my.sample.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class WordCounterAppMainTest {

    LineConverter lineConverter;
    DuplicateCounter duplicateCounter;

    @Mock
    private FromFileReader fromFileReader;

    @Before
    public void setUp(){
        lineConverter = new LineConverter();
        duplicateCounter = new DuplicateCounter();
    }

    @Test
    public void loadFromFile() throws FileNotFoundException {

        List<String> listFromFile;
        List<String> words;
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        Stream<String> stringStream = Stream.of(
                "Жили себе дед да баба. Дед говорит бабе:", "\n", "\r", "\n", "\r", "\n", "\r",
                "— Ты, баба, пеки пироги, а я запрягу сани да поеду за рыбой.");
        listFromFile = stringStream.collect(Collectors.toList());

        when(fromFileReader.loadFromFile(any())).thenReturn(listFromFile);
        final String FILE_NAME = "fdhfdhfshdhxt";
        List<String> linesFromFile = fromFileReader.loadFromFile(FILE_NAME);

        for (String line : linesFromFile) {
            if (!line.isEmpty()) {
                words = lineConverter.extractWords(line);
                duplicateCounter.countWords(words, wordCountMap);
                words.clear();
            }
        }

        assertEquals(17, wordCountMap.size());

    }
}