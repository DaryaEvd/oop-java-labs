import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) throws IOException {
        WordsGenerator.generateTextWithRandomNames();

        HashMap<String, Integer> storeNamesAndTheirAmount = new HashMap<>();

        int globalAmountOfNames = 0;

        CSVFile csvFile = new CSVFile();
        Reader reader = csvFile.reader;
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currString;
            String[] arrayString;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayString = currString.split(" ");
//                System.out.println(Arrays.toString(arrayString));

                for (String s : arrayString) {

                    int countFreq = storeNamesAndTheirAmount.getOrDefault(s, 0);
                    storeNamesAndTheirAmount.put(s, countFreq + 1);
                    globalAmountOfNames++;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            System.err.println("Error " + e.getMessage());
        }

//        System.out.println("HASH MAPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//        for (String name: storeNamesAndTheirAmount.keySet()) {
//            String value = storeNamesAndTheirAmount.get(name).toString();
//            System.out.println(name + ": " + value);
//        }

        HashMap<String, Integer> sortNamesByFrequency = storeNamesAndTheirAmount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

//        String pathOfResultFile = "/home/dasha/IdeaProjects/task1/src/result.csv";
//        File resFile = new File(pathOfResultFile);
//        boolean resultOfCreating;
//        try {
//            resultOfCreating = resFile.createNewFile();
//            if(!resultOfCreating) {
////                System.out.println("File already exists at location: " + fileWithRandNames.getCanonicalPath());
//                //TODO: System.err.print, exit ?
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileWriter fileWriter = new FileWriter(csvFile.output)) {
            fileWriter.write("Word, ");
            fileWriter.write("Frequency, ");
            fileWriter.write("ProcFrequency\n");

            for (String name: sortNamesByFrequency.keySet()) {
                double proc = (double)sortNamesByFrequency.get(name) / globalAmountOfNames;

                String value = sortNamesByFrequency.get(name).toString();
                fileWriter.write(name + ", " + value + ", " + proc + "\n");
            }

        }
    }
}
