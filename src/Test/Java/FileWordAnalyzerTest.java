import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by marti on 2017.05.08..
 */
public class FileWordAnalyzerTest {

    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
        filePartReader.setup("src/test.txt",2,6);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testIsSortedByABC() throws Exception {
        ArrayList<String> result = fileWordAnalyzer.wordsByABC();
        ArrayList<String> expected = new ArrayList<>
                (Arrays.asList("apa", "dghj", "tzut", "vbmhjk", "xftut"));
        assertEquals(expected, result);

    }

    @Test
    public void testIsContainingSubString() throws Exception {
        ArrayList<String> result = fileWordAnalyzer.wordsContainingSubString("ut");
        ArrayList<String> expected = new ArrayList<>
                (Arrays.asList("tzut", "xftut"));
        assertEquals(expected, result);

    }

    @Test
    public void testIsContainingSubStringLowerCase() throws Exception {
        ArrayList<String> result = fileWordAnalyzer.wordsContainingSubString("UT");
        ArrayList<String> expected = new ArrayList<>
                (Arrays.asList("tzut", "xftut"));
        assertEquals(expected, result);

    }

    @Test
    public void testIsWordsArePalindrome() throws Exception {
        ArrayList<String> result = fileWordAnalyzer.wordsArePalindrome();
        ArrayList<String> expected = new ArrayList<>
                (Arrays.asList("apa"));
        assertEquals(expected, result);

    }

}
