import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CSVFile {
    Reader input;
    FileWriter output;

    HashMap<String, Integer> storeNamesAndAmount;
    HashMap<String, Integer> sortNamesByFrequency;

    static int globalAmountOfNames = 0;
    CSVFile() {
        try {
            this.input = new FileReader("/home/dasha/IdeaProjects/task1/src/random_names.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.storeNamesAndAmount = new HashMap<>();
        this.sortNamesByFrequency = new HashMap<>();

        try {
            this.output = new FileWriter("/home/dasha/IdeaProjects/task1/src/result.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void keepData(CSVFile csvFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(csvFile.input);
            String currString;
            String[] arrayOfAllStrings;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayOfAllStrings = currString.split(" ");
                for (String currLine : arrayOfAllStrings) {
                    int countFreq = csvFile.storeNamesAndAmount.getOrDefault(currLine, 0);
                    csvFile.storeNamesAndAmount.put(currLine, countFreq + 1);
                    globalAmountOfNames++;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    static HashMap<String, Integer> sortFreq(CSVFile csvFile) {
        return
             csvFile.storeNamesAndAmount
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                    LinkedHashMap::new));
    }

    void printResultToFile(CSVFile csvFile) throws IOException {
        csvFile.output.write("Word, ");
        csvFile.output.write("Frequency, ");
        csvFile.output.write("ProcFrequency\n");

        for (String name: csvFile.sortNamesByFrequency.keySet()) {
            double proc = (double)csvFile.sortNamesByFrequency.get(name) / globalAmountOfNames;

            String value = csvFile.sortNamesByFrequency.get(name).toString();
            csvFile.output.write(name + ", " + value + ", " + proc + "\n");
        }
    }
}