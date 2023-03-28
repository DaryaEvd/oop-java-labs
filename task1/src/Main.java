import java.io.*;
import java.util.*;

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

                for(int i = 0; i < arrayString.length; i++) {

                    int countFreq = storeNamesAndAmount.containsKey(arrayString[i]) ?
                                storeNamesAndAmount.get(arrayString[i]) : 0;
                    storeNamesAndAmount.put(arrayString[i], countFreq + 1);
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            System.err.println("Error " + e.getMessage());
        }

        System.out.println("HASH MAPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");

        for (String name: storeNamesAndAmount.keySet()) {
            String value = storeNamesAndAmount.get(name).toString();
            System.out.println(name + ": " + value);
        }

    }
}
