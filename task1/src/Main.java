import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        WordsGenerator.generateTextWithRandomNames();

        CSVFile csvFile = new CSVFile();
        csvFile.keepData(csvFile);
        CSVFile.printResultToFile(csvFile);
        csvFile.output.close(); //TODO: ask is it ok to close in main where no open??????
    }
}
