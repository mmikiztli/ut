import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by marti on 2017.05.08..
 */
public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList<String> wordsByABC() throws FileNotFoundException {
        String lines = this.filePartReader.readLines();
        ArrayList<String> linesList = new ArrayList<>(Arrays.asList(lines.split("\n")));
        Collections.sort(linesList);
        return linesList;
    }

    public ArrayList wordsContainingSubString(String subString) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        String lines = this.filePartReader.readLines();
        String[] linesList = lines.split("\n");
        for (String word : linesList) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                result.add(word);
            }
        }
        return result;
    }

    public ArrayList wordsArePalindrome() throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        String lines = this.filePartReader.readLines();
        String[] linesList = lines.split("\n");
        for (String word : linesList) {
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                result.add(word);
            }
        }
        return result;
    }
}
