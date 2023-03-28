import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        WordsGenerator.generateTextWithRandomNames();

        CSVFile csvFile = new CSVFile();
        CSVFile.keepData(csvFile);
        csvFile.sortNamesByFrequency = CSVFile.sortFreq(csvFile);
        csvFile.printResultToFile(csvFile);
        csvFile.output.close();
    }
}