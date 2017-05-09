import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by marti on 2017.05.08..
 */
public class FilePartReaderTest {

    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
    }

    @Test
    public void testIsLineBelow1ThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->
        {filePartReader.setup("src/test.txt",0,5);});
    }

    @Test
    public void testIsFromLineLargerThanToLineThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->
        {filePartReader.setup("src/test.txt",5,1);});
    }

    @Test
    public void testIsLinesPartOfFile() throws Exception {
        filePartReader.setup("src/test.txt",2,5);
        String lines = filePartReader.readLines();
        assertEquals("dghj\n" +
                    "tzut\n" +
                    "apa\n" +
                    "vbmhjk\n", lines);
    }

    @Test
    public void testIsFirstLineIsFirst() throws Exception {
        filePartReader.setup("src/test.txt",1,1);
        String lines = filePartReader.readLines();
        assertEquals("adsf\n", lines);
        }

}
