import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CSVFile {
    HashMap<String, Integer> storeNamesAndAmount;
    HashMap<String, Integer> sortNamesByFrequency;
    static int AmountOfNames = 0;
    CSVFile() {
        this.storeNamesAndAmount = new HashMap<>();
        this.sortNamesByFrequency = new HashMap<>();
    }

    public void keepData() throws IOException {
        String NAME_INPUT_FILE = "/home/dasha/IdeaProjects/task1/src/random_names.txt";
        try(Reader input = new FileReader(NAME_INPUT_FILE);
            BufferedReader bufferedReader = new BufferedReader(input)) {
            String currString;
            String[] arrayOfAllStrings;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayOfAllStrings = currString.split(" ");
                for (String currLine : arrayOfAllStrings) {
                    int countFreq = this.storeNamesAndAmount.getOrDefault(currLine, 0);
                    this.storeNamesAndAmount.put(currLine, countFreq + 1);
                    AmountOfNames++;
                }
            }
        }
    }

    private HashMap<String, Integer> sortFreq() {
        return
            this.storeNamesAndAmount
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
    }

    public void printResultToFile() throws IOException {
        this.sortNamesByFrequency = sortFreq();

        final String NAME_OUTPUT_FILE = "/home/dasha/IdeaProjects/task1/src/result.csv";

        try(FileWriter output = new FileWriter(NAME_OUTPUT_FILE)) {
            output.write("Word, ");
            output.write("Frequency, ");
            output.write("ProcFrequency\n");

            for (String name: this.sortNamesByFrequency.keySet()) {
                double percentage = (double)this.sortNamesByFrequency.get(name) / AmountOfNames;
                String value = this.sortNamesByFrequency.get(name).toString();
                output.write(name + ", " + value + ", " + percentage + "\n");
            }
        }
    }
}