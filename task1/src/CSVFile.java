import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class CSVFile {
    Reader reader;
    File output;
    String word;
    int frequency;
    double procFreq;

    CSVFile() {
        try {
            this.reader = new FileReader(WordsGenerator.inputStr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.output = new File("/home/dasha/IdeaProjects/task1/src/result.csv");

//        this.word = null;
//        this.frequency = 0;
//        this.procFreq = 0.0;
    }
}
