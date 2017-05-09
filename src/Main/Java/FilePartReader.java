import java.io.*;
import java.util.Scanner;

/**
 * Created by marti on 2017.05.08..
 */
public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("not a valid line");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws FileNotFoundException {
        String content = new Scanner(new File(this.filePath)).useDelimiter("\\Z").next();
        return content;
    }

    public String readLines() throws FileNotFoundException {
    String result = "";
    String lines =read();
    String[] splitLines = lines.split("\n");
    for (int i=0; i < splitLines.length; i++) {
        if (i >= this.fromLine-1 && i <= this.toLine-1) {
            result += splitLines[i]+'\n';
        }
    }
    return result;
    }
}
