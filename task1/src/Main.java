import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter inputFileWithNames =  WordsGenerator.generateTextWithRandomNames();
        assert inputFileWithNames != null;
        inputFileWithNames.close();

//        String inputFileName = WordsGenerator.nameInput;


//        CSVFile csvFile = new CSVFile(inputFileName);
////        System.out.println(csvFile.input.getName());
//
        Set<String> treeSet = new TreeSet<String>();

        HashMap<String, Integer> storeNamesAndAmount = new HashMap<>();

//        String pathResFile = "/home/dasha/IdeaProjects/task1/src/result.txt";
//        File resFile = new File(pathResFile);
//        resFile.createNewFile();

        Reader reader = new FileReader("/home/dasha/IdeaProjects/task1/src/random_names.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currString;
            String[] arrayString;
            Integer counter = 0;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayString = currString.split(" ");
                System.out.println(Arrays.toString(arrayString));

//                System.out.println("DATA IN STRING");
                for(int i = 0; i < arrayString.length; i++) {
//                    System.out.println(arrayString[i]);
//                    treeSet.add(arrayString[i]);

                    storeNamesAndAmount.put(arrayString[i], counter++);
                }

//                treeSet.add(Arrays.toString(arrayString)); - add the whole string
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            System.err.println("Error " + e.getMessage());
        }


//        //TODO: magic constant + form words generator
//        for(int i = 0; i < 5; i++) {
//
//        }

//        System.out.println("TREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEET SET");
//        for(String str : treeSet) {
//            System.out.println(str);
//        }

        System.out.println("HASH MAPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//        for (Object objectName : storeNamesAndAmount.keySet()) {
//            System.out.print(objectName);
//            System.out.print(": ");
//            System.out.println(storeNamesAndAmount.get(objectName));
//        }

        for (String name: storeNamesAndAmount.keySet()) {
            String key = name.toString();
            String value = storeNamesAndAmount.get(name).toString();
            System.out.println(key + ": " + value);
        }

    }
}
