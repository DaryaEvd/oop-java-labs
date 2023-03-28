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

    CSVFile() {
        try {
            this.input = new FileReader("/home/dasha/IdeaProjects/task1/src/random_names.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.output = null;

        this.storeNamesAndAmount = new HashMap<>();
        this.sortNamesByFrequency = new HashMap<>();

        try {
            this.output = new FileWriter(new File("/home/dasha/IdeaProjects/task1/src/result.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static void sortFreq(CSVFile csvFile) {
        csvFile.sortNamesByFrequency =
                 csvFile.storeNamesAndAmount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
    }

}