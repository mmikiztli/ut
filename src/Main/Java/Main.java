import java.io.IOException;

/**
 * Created by marti on 2017.05.08..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test.txt", 2,6);
        System.out.println(reader.readLines());
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(reader);
        System.out.println(fileWordAnalyzer.wordsByABC());
        System.out.println(fileWordAnalyzer.wordsContainingSubString("ut"));
        System.out.println(fileWordAnalyzer.wordsArePalindrome());
    }
}
