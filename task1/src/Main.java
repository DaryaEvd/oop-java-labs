import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter inputFileWithNames =  WordsGenerator.generateTextWithRandomNames();
        assert inputFileWithNames != null;
        inputFileWithNames.close();

        HashMap<String, Integer> storeNamesAndAmount = new HashMap<>();

        Reader reader = new FileReader("/home/dasha/IdeaProjects/task1/src/random_names.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currString;
            String[] arrayString;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayString = currString.split(" ");
                System.out.println(Arrays.toString(arrayString));

                for (String s : arrayString) {

                    int countFreq = storeNamesAndAmount.getOrDefault(s, 0);
                    storeNamesAndAmount.put(s, countFreq + 1);
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            System.err.println("Error " + e.getMessage());
        }

//        System.out.println("HASH MAPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//        for (String name: storeNamesAndAmount.keySet()) {
//            String value = storeNamesAndAmount.get(name).toString();
//            System.out.println(name + ": " + value);
//        }

        HashMap<String, Integer> sortNamesByFrequency = new HashMap<>();
        sortNamesByFrequency = storeNamesAndAmount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));


//        System.out.println("AFTER SOOOOOOOOOOOORTING");
//        for (String name: sortNamesByFrequency.keySet()) {
//            String value = sortNamesByFrequency.get(name).toString();
//            System.out.println(name + ": " + value);
//        }

        String pathOfResultFile = "/home/dasha/IdeaProjects/task1/src/result.csv";
        File resFile = new File(pathOfResultFile);
        boolean resultOfCreating;
        try {
            resultOfCreating = resFile.createNewFile();
            if(!resultOfCreating) {
//                System.out.println("File already exists at location: " + fileWithRandNames.getCanonicalPath());
                //TODO: System.err.print, exit ?
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(resFile)) {
            fileWriter.write("Word");
            fileWriter.write(", ");
            fileWriter.write("Frequency\n");

            for (String name: sortNamesByFrequency.keySet()) {
                String value = sortNamesByFrequency.get(name).toString();
                fileWriter.write(name + ", " + value + "\n");
            }
        }

    }
}
