import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        WordsGenerator.generateTextWithRandomNames();

        CSVFile csvFile = new CSVFile();
        csvFile.keepData();
        csvFile.printResultToFile();
    }
}
