import java.io.File;

public class CSVFile {
    File input;
    File output;
    String word;
    int frequency;
    double procFreq;

    CSVFile(String inputFileName) {
        this.input = new File(inputFileName);
        this.output = null;
        this.word = null;
        this.frequency = 0;
        this.procFreq = 0.0;
    }
}
